package com.ages.doacaobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ages.doacaobackend.business.dto.ItemSolicitation.ItemSolicitationEditStatusRequest;
import com.ages.doacaobackend.business.dto.ItemSolicitation.ItemSolicitationRequest;
import com.ages.doacaobackend.business.dto.ItemSolicitation.ItemSolicitationResponse;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.service.ItemSolicitationService;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;

@RestController
@RequestMapping("/itemSolicitation")
public class ItemSolicitationController {

    @Autowired
    ItemSolicitationService itemSolicitationService;
    
    @PostMapping
    public ResponseEntity<ItemSolicitationResponse> createItemSolicitation(@RequestBody ItemSolicitationRequest request) throws EntityNotFoundException {
        return ok(itemSolicitationService.createItemSolicitation(request));   
    }

    @GetMapping
    public ResponseEntity<List<ItemSolicitationResponse>> findAllItemSolicitation() {
        return ok(itemSolicitationService.findAll());
    }

    @PostMapping("/editStatus")
    public ResponseEntity<?> editStatus(@RequestBody ItemSolicitationEditStatusRequest editStatusRequest) throws EntityNotFoundException {
        itemSolicitationService.editStatus(editStatusRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
