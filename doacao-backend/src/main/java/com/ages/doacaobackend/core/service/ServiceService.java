package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.Service.ServiceRequest;
import com.ages.doacaobackend.business.dto.Service.ServiceResponse;
import com.ages.doacaobackend.business.entity.Service;
import com.ages.doacaobackend.business.exception.ItemLimitLessThanOneException;
import com.ages.doacaobackend.core.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService {
    
    @Autowired
    ServiceRepository serviceRepository;

    public List<ServiceResponse> listAllServices() { 
        return serviceRepository.getAllServices();
    }

    public Service findById(int id) {
        return serviceRepository.findById(id);
    }

    public ServiceResponse createService(ServiceRequest request) throws ItemLimitLessThanOneException {
        return serviceRepository.createService(request);
    }
}
