package com.ages.doacaobackend.controller;

import com.ages.doacaobackend.business.dto.Interest.OrderInterestDTO;
import com.ages.doacaobackend.business.dto.Interest.OrderInterestsDTO;
import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderListResponse;
import com.ages.doacaobackend.business.dto.Service.ServiceOrderServiceResponse;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderListResponse;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderRequest;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderResponse;
import com.ages.doacaobackend.business.dto.donation.DonationInterestRequest;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import com.ages.doacaobackend.business.exception.*;
import com.ages.doacaobackend.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/serviceOrder")
public class ServiceOrderController {

    @Autowired
    ServiceOrderService serviceOrderService;

    @Autowired
    ServiceOrderQuantityService serviceOrderQuantityService;

    @Autowired
    ServiceOrderDetailsService serviceOrderDetailsService;

    @Autowired
    DonationInterestService donationInterestService;

    @Autowired
    OrderInterestService interestService;


    @PostMapping
    public ResponseEntity<ServiceOrderResponse> createServiceOrder(@RequestBody ServiceOrderRequest serviceOrderRequest) 
                    throws EntityNotFoundException, ExistingOrderException, DuplicateServiceException, ExcedeedLimitServiceException {
        return ok(serviceOrderQuantityService.createServiceOrder(serviceOrderRequest));
    }

    @GetMapping
    public ResponseEntity<List<ServiceOrderListResponse>> findAllServiceOrders(){
        return ok(serviceOrderDetailsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ServiceOrderServiceResponse>> findAllServicesInOrder(@PathVariable int id){
        return ok(serviceOrderService.findAllServicesInOrder(id));
    }

    @PostMapping("/urgent")
    public ResponseEntity<ServiceOrderResponse> createUrgentServiceOrder(@RequestBody ServiceOrderRequest serviceOrderRequest)
            throws EntityNotFoundException, ExistingOrderException, DuplicateServiceException, ExcedeedLimitServiceException, NotUrgentRequestException {
        return ok(serviceOrderQuantityService.createUrgentServiceOrder(serviceOrderRequest));
    }

    @PostMapping("/registerInterest")
    public ResponseEntity<?> registerInterestForDonation(@RequestBody DonationInterestRequest donatationInterestRequest) throws EntityNotFoundException, MalformedEntityException {
        donationInterestService.notifyInterest(donatationInterestRequest, true);
        interestService.saveServiceOrderInterest(donatationInterestRequest);
        return ok(null);
    }

    @GetMapping("/interest/{uuid}")
    public ResponseEntity<List<String>> findAllServiceResponseInOrder(@PathVariable int uuid){
        return ok(serviceOrderQuantityService.findAllServiceResponseInOrder(uuid));
    }

    @PatchMapping("/")
    public ResponseEntity<Boolean> updateStatus(@RequestParam("status") GeneralStatus status, @RequestParam("orderId") int orderId) {
        serviceOrderDetailsService.updateStatus(status, orderId);
        return ok(true);
    }

    @PostMapping("/editServiceOrder")
    public ResponseEntity<ServiceOrderListResponse> editServiceOrder(@RequestBody ServiceOrderListResponse editRequest) throws EntityNotFoundException {
        return ok(serviceOrderQuantityService.editServiceOrder(editRequest));
    }

    @GetMapping("/interest/{id}/details")
    public ResponseEntity<List<OrderInterestDTO>> findAllInterestsInOrder(@PathVariable int id) {
        List<OrderInterestDTO> list = interestService.listAllServiceInterestsInOrder(id);
        if (list.isEmpty()) return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        return ok(list);
    }

    @GetMapping("/actives/institution/{idInstitution}")
    public ResponseEntity<List<ServiceOrderListResponse>> getActivesByInstitution(@PathVariable int idInstitution){ //TODO mapear quantidade
        return ok(serviceOrderDetailsService.findActivesByInstitution(idInstitution));
    }

    @GetMapping("/city/{city}")
    public List<ServiceOrderListResponse> getServiceOrdersByCity(@PathVariable String city) {
        return serviceOrderDetailsService.findAllByInstitutionCity(city);
    }
}
