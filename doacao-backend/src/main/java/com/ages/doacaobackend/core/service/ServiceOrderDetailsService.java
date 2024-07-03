package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderListResponse;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderListResponse;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderRequest;
import com.ages.doacaobackend.business.entity.Institution;
import com.ages.doacaobackend.business.entity.ProductDetailsOrder;
import com.ages.doacaobackend.business.entity.ServiceDetailsOrder;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.messaging.EmailSender;
import com.ages.doacaobackend.core.repository.ServiceOrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ages.doacaobackend.core.messaging.EmailMessages.*;

@Service
public class ServiceOrderDetailsService {
    
    @Autowired
    ServiceOrderDetailsRepository serviceOrderDetailsRepository;

    @Autowired
    EmailSender emailSender;

    public ServiceDetailsOrder createDetailsOrder(ServiceOrderRequest serviceOrderRequest) throws EntityNotFoundException {
        return serviceOrderDetailsRepository.createDetailsOrder(serviceOrderRequest);
    }

    public int findDetailsOrder(int id) {
        return serviceOrderDetailsRepository.findDetailsOrder(id);
    }

    public ServiceDetailsOrder findById(int id) throws EntityNotFoundException {
        return serviceOrderDetailsRepository.findById(id);
    }

    public List<ServiceOrderListResponse> findAll(){
        return serviceOrderDetailsRepository.findAll();
    }

    public int findUrgentDetailsOrder(int id) {
        return serviceOrderDetailsRepository.findUrgentDetailsOrder(id);
    }

    public ServiceDetailsOrder createUrgentDetailsOrder(ServiceOrderRequest serviceOrderRequest) throws EntityNotFoundException {
        return serviceOrderDetailsRepository.createUrgentDetailsOrder(serviceOrderRequest);
    }

    public Institution getInstitutionFromOrderId(int orderId) {
        return serviceOrderDetailsRepository.getInstitutionIdFromOrder(orderId);
    }

    public void updateStatus(GeneralStatus status, int orderId) {
        Institution institution = getInstitutionFromOrderId(orderId);
        serviceOrderDetailsRepository.updateStatus(status, orderId);
        emailSender.sendEmail(
                status == GeneralStatus.A ? NOTIFY_UPDATE_URGENT_ORDER_MESSAGE : NOTIFY_UPDATE_URGENT_ORDER_DECLINED_MESSAGE,
                NOTIFY_UPDATE_URGENT_ORDER_SUBJECT,
                institution.getEmail()
        );
    }

    public List<ServiceOrderListResponse> findActivesByInstitution(int idInstitution) {
        return serviceOrderDetailsRepository.findActivesByInstitution(idInstitution);
    }

     public List<ServiceOrderListResponse> findAllByInstitutionCity(String city) {
        return serviceOrderDetailsRepository.findAllByInstitutionCity(city);
    }
}
