package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderListResponse;
import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderRequest;
import com.ages.doacaobackend.business.entity.Institution;
import com.ages.doacaobackend.business.entity.ProductDetailsOrder;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.messaging.EmailSender;
import com.ages.doacaobackend.core.repository.ProductOrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ages.doacaobackend.core.messaging.EmailMessages.NOTIFY_UPDATE_URGENT_ORDER_MESSAGE;
import static com.ages.doacaobackend.core.messaging.EmailMessages.NOTIFY_UPDATE_URGENT_ORDER_DECLINED_MESSAGE;
import static com.ages.doacaobackend.core.messaging.EmailMessages.NOTIFY_UPDATE_URGENT_ORDER_SUBJECT;

@Service
public class ProductOrderDetailsService {

    @Autowired
    private ProductOrderDetailsRepository productOrderRepository;

    @Autowired
    EmailSender emailSender;

    public ProductDetailsOrder createDetailsOrder(ProductOrderRequest orderRequest) throws EntityNotFoundException {
        return productOrderRepository.createDetailsOrder(orderRequest);
    }

    public int findDetailsOrder(int id) {
        return productOrderRepository.findDetailsOrder(id);
    }

    public ProductDetailsOrder findById(int id) throws EntityNotFoundException {
        return productOrderRepository.findById(id);
    }

    public int findUrgentDetailsOrder(int id) {
        return productOrderRepository.findUrgentDetailsOrder(id);
    }

    public List<ProductOrderListResponse> findAll() {
        return productOrderRepository.findAll();
    }

    public Institution findInstitutionByOrderId(int orderId) {
        return productOrderRepository.getInstitutionFromOrderId(orderId);
    }
    public ProductDetailsOrder createUrgentDetailsOrder(ProductOrderRequest orderRequest) throws EntityNotFoundException {
        return productOrderRepository.createUrgentDetailsOrder(orderRequest);
    }

    public void updateStatus(GeneralStatus status, int orderId) {
        Institution institution = findInstitutionByOrderId(orderId);
        productOrderRepository.updateStatus(status, orderId);
        emailSender.sendEmail(
                status == GeneralStatus.A ? NOTIFY_UPDATE_URGENT_ORDER_MESSAGE : NOTIFY_UPDATE_URGENT_ORDER_DECLINED_MESSAGE,
                NOTIFY_UPDATE_URGENT_ORDER_SUBJECT,
                institution.getEmail()
        );
    }
    
    public List<ProductOrderListResponse> findActivesByInstitution(int idInstitution){
        return productOrderRepository.findActivesByInstitution(idInstitution);
    }

    public String findCityByOrderId(int orderId) {
        return productOrderRepository.findCityByOrderId(orderId);
    }

    public List<ProductDetailsOrder> findAllByInstitutionCity(String city) {
        return productOrderRepository.findAllByInstitutionCity(city);
    }
}
