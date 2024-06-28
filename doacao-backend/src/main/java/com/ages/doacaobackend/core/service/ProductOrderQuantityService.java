package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderListResponse;
import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderRequest;
import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderResponse;
import com.ages.doacaobackend.business.entity.ProductQuantityOrder;
import com.ages.doacaobackend.business.exception.*;
import com.ages.doacaobackend.core.messaging.EmailSender;
import com.ages.doacaobackend.core.repository.ProductOrderQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ages.doacaobackend.core.messaging.EmailMessages.NOTIFY_ADMIN_NEW_URGENT_ORDER_MESSAGE;
import static com.ages.doacaobackend.core.messaging.EmailMessages.NOTIFY_ADMIN_NEW_URGENT_ORDER_SUBJECT;

@Service
public class ProductOrderQuantityService {
    
    @Autowired
    @Lazy
    ProductOrderQuantityRepository repository;

    @Autowired
    AdminService adminService;

    @Autowired
    EmailSender sender;

    public ProductOrderResponse createProductOrder(ProductOrderRequest productOrderRequest) throws EntityNotFoundException, ExistingOrderException, DuplicateProductException, ExcedeedLimitProductException, WrongProductUnitMeasurement {
        return repository.createProductOrder(productOrderRequest);
    }

    public List<ProductQuantityOrder> findAllProductQuantityOrder(int idOrder) {
        return repository.findAllProductQuantityOrder(idOrder);
    }

    public ProductOrderResponse createUrgentProductOrder(ProductOrderRequest productOrderRequest) throws EntityNotFoundException, ExistingOrderException, DuplicateProductException, ExcedeedLimitProductException, WrongProductUnitMeasurement, NotUrgentRequestException {
        ProductOrderResponse response = repository.createUrgentProductOrder(productOrderRequest);
        for (AdminDTO admin: adminService.getAll()) {
            sender.sendEmail(
                    NOTIFY_ADMIN_NEW_URGENT_ORDER_MESSAGE + response.getIdProductDetailsOrder(),
                    NOTIFY_ADMIN_NEW_URGENT_ORDER_SUBJECT,
                    admin.getEmail()
            );
        }
        return response;
    }

    public List<String> findAllProductResponseInOrder(int idOrder) {
        return repository.findAllProductResponseInOrder(idOrder);
    }

    public ProductOrderListResponse editProductOrder(ProductOrderListResponse editRequest) throws EntityNotFoundException {
        return repository.editProductOrder(editRequest);
    }
}
