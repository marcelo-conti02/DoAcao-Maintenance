package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderListResponse;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderRequest;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderResponse;
import com.ages.doacaobackend.business.entity.ServiceQuantityOrder;
import com.ages.doacaobackend.business.exception.*;
import com.ages.doacaobackend.core.messaging.EmailSender;
import com.ages.doacaobackend.core.repository.ServiceOrderQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ages.doacaobackend.core.messaging.EmailMessages.NOTIFY_ADMIN_NEW_URGENT_ORDER_MESSAGE;
import static com.ages.doacaobackend.core.messaging.EmailMessages.NOTIFY_ADMIN_NEW_URGENT_ORDER_SUBJECT;

@Service
public class ServiceOrderQuantityService {
    
    @Autowired
    @Lazy
    ServiceOrderQuantityRepository serviceOrderRepository;

    @Autowired
    AdminService adminService;

    @Autowired
    EmailSender sender;

    public ServiceOrderResponse createServiceOrder(ServiceOrderRequest serviceOrderRequest) throws EntityNotFoundException, ExistingOrderException, 
                                                                                                    DuplicateServiceException, ExcedeedLimitServiceException {
        return serviceOrderRepository.createServiceOrder(serviceOrderRequest);
    }

    public List<ServiceQuantityOrder> findAllQuantityServiceOrders(int idOrder) {
        return serviceOrderRepository.findAllQuantityServiceOrders(idOrder);
    }

    public ServiceOrderResponse createUrgentServiceOrder(ServiceOrderRequest serviceOrderRequest) throws EntityNotFoundException, ExistingOrderException,
            DuplicateServiceException, ExcedeedLimitServiceException, NotUrgentRequestException {
        ServiceOrderResponse response = serviceOrderRepository.createUrgetServiceOrder(serviceOrderRequest);
        for (AdminDTO admin: adminService.getAll()) {
            sender.sendEmail(
                    NOTIFY_ADMIN_NEW_URGENT_ORDER_MESSAGE + response.getIdServiceDetailsOrder(),
                    NOTIFY_ADMIN_NEW_URGENT_ORDER_SUBJECT,
                    admin.getEmail()
            );
        }
        return response;
    }


    public List<String> findAllServiceResponseInOrder(int idOrder) {
        return serviceOrderRepository.findAllServiceResponseInOrder(idOrder);
    }

    public ServiceOrderListResponse editServiceOrder(ServiceOrderListResponse editRequest) throws EntityNotFoundException {
        return serviceOrderRepository.editServiceOrder(editRequest);
    }
}
