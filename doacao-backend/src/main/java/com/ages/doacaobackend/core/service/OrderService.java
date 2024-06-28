package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.urgentOrder.UrgentOrderResponse;
import com.ages.doacaobackend.business.entity.ProductDetailsOrder;
import com.ages.doacaobackend.business.entity.ServiceDetailsOrder;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.mappers.InstitutionMapper;
import com.ages.doacaobackend.core.repository.ProductOrderDetailsRepository;
import com.ages.doacaobackend.core.repository.ProductOrderQuantityRepository;
import com.ages.doacaobackend.core.repository.ServiceOrderDetailsRepository;
import com.ages.doacaobackend.core.repository.ServiceOrderQuantityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {

    private final ProductOrderQuantityRepository productOrderQuantityRepository;
    private final ServiceOrderQuantityRepository serviceOrderQuantityRepository;
    private final ProductOrderDetailsRepository productOrderDetailsRepository;
    private final ServiceOrderDetailsRepository serviceOrderDetailsRepository;
    private final InstitutionMapper mapper;

    public OrderService(
            ProductOrderQuantityRepository productOrderQuantityRepository,
            ServiceOrderQuantityRepository serviceOrderQuantityRepository,
            ProductOrderDetailsRepository productOrderDetailsRepository,
            ServiceOrderDetailsRepository serviceOrderDetailsRepository,
            InstitutionMapper mapper) {
        this.productOrderQuantityRepository = productOrderQuantityRepository;
        this.serviceOrderQuantityRepository = serviceOrderQuantityRepository;
        this.productOrderDetailsRepository = productOrderDetailsRepository;
        this.serviceOrderDetailsRepository = serviceOrderDetailsRepository;
        this.mapper = mapper;
    }

    public List<UrgentOrderResponse> getAllUrgentOrders() throws EntityNotFoundException {
        List<ProductDetailsOrder> urgentProductOrders = productOrderDetailsRepository.findAllAnalysisUrgentOrders();
        List<ServiceDetailsOrder> urgentServiceOrders = serviceOrderDetailsRepository.findAllAnalysisUrgentOrders();

        if (urgentServiceOrders.isEmpty() && urgentProductOrders.isEmpty()) return Collections.emptyList();

        ArrayList<UrgentOrderResponse>  urgentOrders = new ArrayList<>();
        for (ProductDetailsOrder order : urgentProductOrders) {
            urgentOrders.add(productOrderToGenericUrgentOrder(order));
        }
        for (ServiceDetailsOrder order : urgentServiceOrders) {
            urgentOrders.add(serviceOrderToGenericUrgentOrder(order));
        }
        urgentOrders.sort((o1, o2) -> {
            if (o1.getCreatedAt().isAfter(o2.getCreatedAt())) return 5;
            if (o1.getCreatedAt().isBefore(o2.getCreatedAt())) return -5;
            return 0;
        });
        return urgentOrders;
    }

    private UrgentOrderResponse productOrderToGenericUrgentOrder(ProductDetailsOrder order) {
        return new UrgentOrderResponse (
                order.getIdProductDetailsOrder(),
                productOrderQuantityRepository.findProductsAndQuantitiesFromOrder(order.getIdProductDetailsOrder()),
                false,
                mapper.institutionToInstitutionResponse(order.getIdInstitution()),
                order.getCreatedTime(),
                order.getDescription()
        );
    }

    private UrgentOrderResponse serviceOrderToGenericUrgentOrder(ServiceDetailsOrder order) {
        return new UrgentOrderResponse (
                order.getIdServiceDetailsOrder(),
                serviceOrderQuantityRepository.findServicesAndQuantitiesFromOrder(order.getIdServiceDetailsOrder()),
                true,
                mapper.institutionToInstitutionResponse(order.getIdInstitution()),
                order.getCreatedTime(),
                order.getDescription()
        );
    }
}
