package com.ages.doacaobackend.controller;


import com.ages.doacaobackend.business.dto.Service.ServiceRequest;
import com.ages.doacaobackend.business.dto.Service.ServiceResponse;
import com.ages.doacaobackend.business.exception.ItemLimitLessThanOneException;
import com.ages.doacaobackend.core.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public ResponseEntity<?> getAllServices() {
        return ResponseEntity.ok(serviceService.listAllServices());
    }

    @PostMapping
    public ResponseEntity<ServiceResponse> createService(@RequestBody ServiceRequest request)
            throws ItemLimitLessThanOneException {
        return new ResponseEntity<ServiceResponse>(serviceService.createService(request),
                HttpStatus.CREATED);
    }
}
