package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderProductResponse;
import com.ages.doacaobackend.core.repository.ProductOrderDetailsRepository;
import com.ages.doacaobackend.core.repository.ProductOrderQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {

    @Autowired
    ProductOrderDetailsRepository detailsRepository;
    
    @Autowired
    ProductOrderQuantityRepository quantityRepository;

    public ProductOrderService(ProductOrderDetailsRepository detailsRepository, ProductOrderQuantityRepository quantityRepository) {
        this.detailsRepository = detailsRepository;
        this.quantityRepository = quantityRepository;
    }

    public List<ProductOrderProductResponse> getAllProductsInOrder(int id) {
        return quantityRepository.getAllProductsInOrder(id);
    }
}
