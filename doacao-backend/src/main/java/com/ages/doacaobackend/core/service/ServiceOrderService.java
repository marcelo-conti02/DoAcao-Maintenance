package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.Service.ServiceOrderServiceResponse;
import com.ages.doacaobackend.core.repository.ServiceOrderDetailsRepository;
import com.ages.doacaobackend.core.repository.ServiceOrderQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrderService {

    @Autowired
    ServiceOrderQuantityRepository quantityRepository;

    @Autowired
    ServiceOrderDetailsRepository detailsRepository;


    public List<ServiceOrderServiceResponse> findAllServicesInOrder(int id) {
        return quantityRepository.findAllServicesInOrder(id);
    }
}
