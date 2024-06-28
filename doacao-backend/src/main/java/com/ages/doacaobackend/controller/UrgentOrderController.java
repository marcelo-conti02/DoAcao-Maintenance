package com.ages.doacaobackend.controller;

import com.ages.doacaobackend.business.dto.urgentOrder.UrgentOrderResponse;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/urgent")
public class UrgentOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<UrgentOrderResponse>> getAllUrgentOrders() throws EntityNotFoundException {
        return ok(orderService.getAllUrgentOrders());
    }

}
