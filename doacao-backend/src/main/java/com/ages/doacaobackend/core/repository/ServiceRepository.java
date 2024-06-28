package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Service.ServiceRequest;
import com.ages.doacaobackend.business.dto.Service.ServiceResponse;
import com.ages.doacaobackend.business.entity.Service;
import com.ages.doacaobackend.business.exception.ItemLimitLessThanOneException;
import com.ages.doacaobackend.business.mappers.ServiceMapper;
import com.ages.doacaobackend.core.operation.ServiceOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ages.doacaobackend.controller.handler.logMessages.ErrorMessages.ITEM_LIMIT_LESS_ONE;

@Repository
public class ServiceRepository {
    
    @Autowired
    ServiceOperationRepository operationRepository;
    
    @Autowired
    ServiceMapper mapper;

    public List<ServiceResponse> getAllServices() {
        List<Service> services = operationRepository.findAll();
        List<ServiceResponse> response = new ArrayList<>();

        services = services.stream()
                           .sorted(Comparator.comparing(Service::getName))
                           .collect(Collectors.toList());

        for (Service service : services) {
            response.add(mapper.serviceToServiceResponse(service));
        }

        return response;
    } 

    public Service findById(int id) {
        Optional<Service> service = operationRepository.findById(id);

        if(!service.isPresent()) throw new EntityNotFoundException(String.valueOf(id));

        return service.get();
    }

    public ServiceResponse createService(ServiceRequest request) throws ItemLimitLessThanOneException {
        if (request.getLimitService() <= 0)
            throw new ItemLimitLessThanOneException(String.format(ITEM_LIMIT_LESS_ONE, request.getLimitService()));

        Service service = new Service()
                .withName(request.getName())
                .withLimitService(request.getLimitService());


        operationRepository.save(service);

        return mapper.serviceToServiceResponse(service);
    }
}
