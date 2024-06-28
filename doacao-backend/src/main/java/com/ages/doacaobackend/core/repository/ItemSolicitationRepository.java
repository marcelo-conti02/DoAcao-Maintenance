package com.ages.doacaobackend.core.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ages.doacaobackend.business.dto.ItemSolicitation.ItemSolicitationEditStatusRequest;
import com.ages.doacaobackend.business.dto.ItemSolicitation.ItemSolicitationRequest;
import com.ages.doacaobackend.business.dto.ItemSolicitation.ItemSolicitationResponse;
import com.ages.doacaobackend.business.entity.ItemSolicitation;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.messaging.EmailSender;
import com.ages.doacaobackend.core.operation.ItemSolicitationOperationRepository;
import com.ages.doacaobackend.core.service.InstitutionService;
import static com.ages.doacaobackend.core.messaging.EmailMessages.*;


@Repository
public class ItemSolicitationRepository {

    @Autowired
    ItemSolicitationOperationRepository operationRepository;

    @Autowired
    InstitutionService institutionService;

    @Autowired
    EmailSender sender;
    
    public ItemSolicitationResponse createItemSolicitation(ItemSolicitationRequest request) throws EntityNotFoundException {
        ItemSolicitationResponse dto = new ItemSolicitationResponse();

        ItemSolicitation solicitation = new ItemSolicitation();

        solicitation.withIdInstitution(institutionService.getPureInstitution(request.getIdInstitution()))
                    .withCreatedTime(LocalDateTime.now())
                    .withItem(request.getItem())
                    .withStatus(GeneralStatus.P);

        ItemSolicitation createdSolicitation = operationRepository.save(solicitation);

        

        return dto.withIdItemSolicitationResponse(createdSolicitation.getIdItemSolicitation())
                  .withIdInstitution(createdSolicitation.getIdInstitution().getId_institution())
                  .withCreatedTime(createdSolicitation.getCreatedTime())
                  .withItem(createdSolicitation.getItem())
                  .withGeneralStatus(createdSolicitation.getStatus());
    }

    public List<ItemSolicitationResponse> findAll() {
        List<ItemSolicitationResponse> itemSolicitations = new ArrayList<>();

        List<ItemSolicitation> solicitations = operationRepository.findAll().stream().filter(x -> x.getStatus() == GeneralStatus.P).collect(Collectors.toList());

        for(ItemSolicitation i : solicitations) {
            itemSolicitations.add(new ItemSolicitationResponse(i));
        }

        return itemSolicitations;
    }

    public void editStatus(ItemSolicitationEditStatusRequest editStatusRequest) throws EntityNotFoundException {
        Optional<ItemSolicitation> itemSolicitation = operationRepository.findById(editStatusRequest.getId());

        if(!itemSolicitation.isPresent()) {
            throw new EntityNotFoundException(String.valueOf(editStatusRequest.getId()));
        }   

        ItemSolicitation solicitation = itemSolicitation.get();
        solicitation.withStatus(GeneralStatus.valueOf(editStatusRequest.getStatus()));

        operationRepository.save(solicitation);

        sender.sendEmail(
            String.format(ITEM_STATUS_UPDATE_MESSAGE, solicitation.getItem(), solicitation.getStatus().getStatus()), 
            ITEM_STATUS_UPDATE_SUBJECT,
            solicitation.getIdInstitution().getEmail()
         );
    }
}
