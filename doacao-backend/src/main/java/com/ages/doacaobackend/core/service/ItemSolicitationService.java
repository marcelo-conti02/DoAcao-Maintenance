package com.ages.doacaobackend.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.dto.ItemSolicitation.ItemSolicitationEditStatusRequest;
import com.ages.doacaobackend.business.dto.ItemSolicitation.ItemSolicitationRequest;
import com.ages.doacaobackend.business.dto.ItemSolicitation.ItemSolicitationResponse;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.messaging.EmailSender;
import com.ages.doacaobackend.core.repository.ItemSolicitationRepository;
import static com.ages.doacaobackend.core.messaging.EmailMessages.*;

import java.util.List;


@Service
public class ItemSolicitationService {
    
    @Autowired
    ItemSolicitationRepository repository;

    @Autowired
    AdminService adminService;

    @Autowired
    EmailSender sender;

    public ItemSolicitationResponse createItemSolicitation(ItemSolicitationRequest request) throws EntityNotFoundException {
        ItemSolicitationResponse response =  repository.createItemSolicitation(request);

        for(AdminDTO admin : adminService.getAll()) {
            sender.sendEmail(
                NOTIFY_ADMIN_NEW_ITEM_SOLICITED_MESSAGE,
                NOTIFY_ADMIN_NEW_ITEM_SOLICITED_SUBJECT,
                admin.getEmail()
            );
        }
        
        return response;
    }

    public List<ItemSolicitationResponse> findAll() {
        return repository.findAll();
    }

    public void editStatus(ItemSolicitationEditStatusRequest editStatusRequest) throws EntityNotFoundException {
        repository.editStatus(editStatusRequest);
    }

}
