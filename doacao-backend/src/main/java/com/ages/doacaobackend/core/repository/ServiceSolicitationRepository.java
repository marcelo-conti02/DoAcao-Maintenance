package com.ages.doacaobackend.core.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ages.doacaobackend.business.dto.ServiceSolicitation.ServiceSolicitationEditStatusRequest;
import com.ages.doacaobackend.business.dto.ServiceSolicitation.ServiceSolicitationRequest;
import com.ages.doacaobackend.business.dto.ServiceSolicitation.ServiceSolicitationResponse;
import com.ages.doacaobackend.business.entity.ServiceSolicitation;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.messaging.EmailSender;
import com.ages.doacaobackend.core.operation.ServiceSolicitationOperationRepository;
import com.ages.doacaobackend.core.service.InstitutionService;
import static com.ages.doacaobackend.core.messaging.EmailMessages.*;


@Repository
public class ServiceSolicitationRepository {
    
    @Autowired
    ServiceSolicitationOperationRepository operationRepository;

    @Autowired
    InstitutionService institutionService;

    @Autowired
    EmailSender sender;

    public ServiceSolicitationResponse createServiceSolicitation(ServiceSolicitationRequest request) throws EntityNotFoundException {
        ServiceSolicitationResponse dto = new ServiceSolicitationResponse();

        ServiceSolicitation solicitation = new ServiceSolicitation();

        solicitation.withIdInstitution(institutionService.getPureInstitution(request.getIdInstitution()))
                    .withCreatedTime(LocalDateTime.now())
                    .withService(request.getService())
                    .withStatus(GeneralStatus.P);

        
        ServiceSolicitation createdSolicitation = operationRepository.save(solicitation);

        return dto.withIdServiceSolicitationResponse(createdSolicitation.getIdServiceSolicitation())
                  .withIdInstitution(createdSolicitation.getIdInstitution().getId_institution())
                  .withCreatedTime(createdSolicitation.getCreatedTime())
                  .withService(createdSolicitation.getService())
                  .withStatus(createdSolicitation.getStatus());
    }

    public List<ServiceSolicitationResponse> findAll() {
        List<ServiceSolicitationResponse> serviceSolicitations = new ArrayList<>();

        List<ServiceSolicitation> solicitations = operationRepository.findAll().stream().filter(x -> x.getStatus() == GeneralStatus.P).collect(Collectors.toList());

        for(ServiceSolicitation i : solicitations) {
            serviceSolicitations.add(new ServiceSolicitationResponse(i));
        }

        return serviceSolicitations;
    }

    public void editStatus(ServiceSolicitationEditStatusRequest editStatusRequest) throws EntityNotFoundException {
        Optional<ServiceSolicitation> serviceSolicitation = operationRepository.findById(editStatusRequest.getId());

        if(!serviceSolicitation.isPresent()) {
            throw new EntityNotFoundException(String.valueOf(editStatusRequest.getId()));
        }   

        ServiceSolicitation solicitation = serviceSolicitation.get();
        solicitation.withStatus(GeneralStatus.valueOf(editStatusRequest.getStatus()));

        operationRepository.save(solicitation);

        sender.sendEmail(
            String.format(SERVICE_STATUS_UPDATE_MESSAGE, solicitation.getService(), solicitation.getStatus().getStatus()), 
            SERVICE_STATUS_UPDATE_SUBJECT,
            solicitation.getIdInstitution().getEmail()
         );
    }
}
