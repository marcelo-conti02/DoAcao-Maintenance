package com.ages.doacaobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ages.doacaobackend.business.dto.ServiceSolicitation.ServiceSolicitationEditStatusRequest;
import com.ages.doacaobackend.business.dto.ServiceSolicitation.ServiceSolicitationRequest;
import com.ages.doacaobackend.business.dto.ServiceSolicitation.ServiceSolicitationResponse;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.service.ServiceSolicitationService;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;


@RestController
@RequestMapping("/serviceSolicitation")
public class ServiceSolicitationController {

    @Autowired
    ServiceSolicitationService serviceSolicitationService;

    @PostMapping
    public ResponseEntity<ServiceSolicitationResponse> createServiceSolicitation(@RequestBody ServiceSolicitationRequest request) throws EntityNotFoundException {
        return ok(serviceSolicitationService.createServiceSolicitation(request));   
    }

    @GetMapping
    public ResponseEntity<List<ServiceSolicitationResponse>> findAllItemSolicitation() {
        return ok(serviceSolicitationService.findAll());
    }

    @PostMapping("/editStatus")
    public ResponseEntity<?> editStatus(@RequestBody ServiceSolicitationEditStatusRequest editStatusRequest) throws EntityNotFoundException {
        serviceSolicitationService.editStatus(editStatusRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
