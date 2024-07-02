package com.ages.doacaobackend.controller;

import com.ages.doacaobackend.business.dto.Interest.OrderInterestDTO;
import com.ages.doacaobackend.business.dto.ProductOrder.*;
import com.ages.doacaobackend.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ages.doacaobackend.business.dto.donation.DonationInterestRequest;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import com.ages.doacaobackend.business.exception.*;


import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/productOrder")
public class ProductOrderController {

    @Autowired
    ProductOrderQuantityService productOrderService;

    @Autowired
    ProductOrderDetailsService productOrderDetailsService;

    @Autowired
    DonationInterestService donationInterestService;
    
    @Autowired
    ProductOrderService orderService;

    @Autowired
    OrderInterestService interestService;

    @PostMapping
    public ResponseEntity<ProductOrderResponse> createProductOrder(@RequestBody ProductOrderRequest productOrderRequest)
            throws EntityNotFoundException, ExistingOrderException, DuplicateProductException, ExcedeedLimitProductException, WrongProductUnitMeasurement {
        return ok(productOrderService.createProductOrder(productOrderRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProductOrderListResponse>> findAllServiceOrders(){
        return ok(productOrderDetailsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductOrderProductResponse>> findAllProductsInOrder(@PathVariable int id){
        return ok(orderService.getAllProductsInOrder(id));
    }

    @PostMapping("/urgent")
    public ResponseEntity<ProductOrderResponse> createUrgentProductOrder(@RequestBody ProductOrderRequest productOrderRequest)
            throws EntityNotFoundException, ExistingOrderException, DuplicateProductException, ExcedeedLimitProductException, WrongProductUnitMeasurement, NotUrgentRequestException {
        return ok(productOrderService.createUrgentProductOrder(productOrderRequest));
    }

    @PostMapping("/registerInterest")
    public ResponseEntity<?> registerInterestForDonation(@RequestBody DonationInterestRequest donatationInterestRequest) throws EntityNotFoundException, MalformedEntityException {
        donationInterestService.notifyInterest(donatationInterestRequest, false);
        interestService.saveProductOrderInterest(donatationInterestRequest);
        return ok(null);
    }

    @GetMapping("/interest/{uuid}")
    public ResponseEntity<List<String>> findAllProductResponseInOrder(@PathVariable int uuid){
        return ok(productOrderService.findAllProductResponseInOrder(uuid));
    }

    @GetMapping("/interest/{id}/details")
    public ResponseEntity<List<OrderInterestDTO>> findAllInterestsInOrder(@PathVariable int id) {
        List<OrderInterestDTO> list = interestService.listAllProductInterestsInOrder(id);
        if (list.isEmpty()) return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        return ok(list);
    }

    @PatchMapping("/")
    public ResponseEntity<Boolean> updateStatus(@RequestParam("status") GeneralStatus status, @RequestParam("orderId") int orderId) {
        productOrderDetailsService.updateStatus(status, orderId);
        return ok(true);
    }
    
    @GetMapping("/actives/institution/{idInstitution}")
    public ResponseEntity<List<ProductOrderListResponse>> getActivesByInstitution(@PathVariable int idInstitution){ //TODO mapear quantidade
        return ok(productOrderDetailsService.findActivesByInstitution(idInstitution));
    }

    @PostMapping("/editProductOrder")
    public ResponseEntity<ProductOrderListResponse> editProductOrder(@RequestBody ProductOrderListResponse editRequest) throws EntityNotFoundException {
        return ok(productOrderService.editProductOrder(editRequest));
    }

    @GetMapping("/city/{orderId}")
    public ResponseEntity<String> getOrderCity(@PathVariable int orderId) {
        String city = productOrderDetailsService.findCityByOrderId(orderId);
        if (city != null) {
            return ResponseEntity.ok(city);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

