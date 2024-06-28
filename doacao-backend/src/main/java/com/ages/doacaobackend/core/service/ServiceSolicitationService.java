package com.ages.doacaobackend.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.dto.ServiceSolicitation.ServiceSolicitationEditStatusRequest;
import com.ages.doacaobackend.business.dto.ServiceSolicitation.ServiceSolicitationRequest;
import com.ages.doacaobackend.business.dto.ServiceSolicitation.ServiceSolicitationResponse;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.messaging.EmailSender;
import com.ages.doacaobackend.core.repository.ServiceSolicitationRepository;
import static com.ages.doacaobackend.core.messaging.EmailMessages.*;

import java.util.List;


@Service
public class ServiceSolicitationService {

    @Autowired
    ServiceSolicitationRepository repository;

    @Autowired
    EmailSender sender;

    @Autowired
    AdminService adminService;

    public ServiceSolicitationResponse createServiceSolicitation(ServiceSolicitationRequest request) throws EntityNotFoundException {
        ServiceSolicitationResponse response = repository.createServiceSolicitation(request);   
 
        for(AdminDTO admin : adminService.getAll()) {
            sender.sendEmail(
                NOTIFY_ADMIN_NEW_SERVICE_SOLICITED_MESSAGE,
                NOTIFY_ADMIN_NEW_SERVICE_SOLICITED_SUBJECT,
                admin.getEmail()
            );
        }

        return response;
    }

    public List<ServiceSolicitationResponse> findAll() {
        return repository.findAll();
    }

    public void editStatus(ServiceSolicitationEditStatusRequest editStatusRequest) throws EntityNotFoundException {
        repository.editStatus(editStatusRequest);
    }
    
}
