package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Interest.OrderInterestDTO;
import com.ages.doacaobackend.business.dto.Interest.OrderInterestsDTO;
import com.ages.doacaobackend.business.dto.donation.DonationInterestRequest;
import com.ages.doacaobackend.business.dto.donation.Interest;
import com.ages.doacaobackend.business.entity.ProductDetailsOrder;
import com.ages.doacaobackend.business.entity.ProductInterest;
import com.ages.doacaobackend.business.entity.ProductOrderInterest;
import com.ages.doacaobackend.core.operation.ItemOperationRepository;
import com.ages.doacaobackend.core.operation.ProductInterestOperationRepository;
import com.ages.doacaobackend.core.operation.ProductOrderDetailsOperationRepository;
import com.ages.doacaobackend.core.operation.ProductOrderInterestOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductInterestRepository {

    @Autowired
    ProductInterestOperationRepository productInterestOperationRepository;

    @Autowired
    ProductOrderInterestOperationRepository productOrderInterestOperationRepository;

    @Autowired
    ProductOrderDetailsOperationRepository productOrderDetailsOperationRepository;

    @Autowired
    ItemOperationRepository itemOperationRepository;

    public void createServiceInterest(final DonationInterestRequest request) {
        ProductOrderInterest productOrderInterest = new ProductOrderInterest();
        ProductDetailsOrder productDetailsOrder = productOrderDetailsOperationRepository.findById(request.getOrderId()).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
        productOrderInterest.setIdProductDetailsOrder(productDetailsOrder);
        productOrderInterest.setIdInstitution(productDetailsOrder.getIdInstitution());
        productOrderInterest.setName(request.getName());
        productOrderInterest.setPhone(request.getPhone());
        productOrderInterest.setEmail(request.getEmail());
        productOrderInterest.setActive(true);
        ProductOrderInterest persistedProductOrderInterest = productOrderInterestOperationRepository.save(productOrderInterest);

        for (Interest product : request.getItemsAndQuantities()) {
            ProductInterest productInterest = new ProductInterest();
            productInterest.setIdProductOrderInterest(persistedProductOrderInterest);
            productInterest.setItem(itemOperationRepository.findByName(product.getInterestName()).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada")));
            productInterest.setQuantity(product.getAmount());
            productInterestOperationRepository.save(productInterest);
        }
    }

    public List<OrderInterestDTO> listAllInterestsInOrder(final int id) {
        List<ProductOrderInterest> orderInterests = productOrderInterestOperationRepository.findAllByOrderId(id);
        if (orderInterests.isEmpty()) return Collections.emptyList();

        return orderInterests.stream()
                .map(x -> new OrderInterestDTO(
                        x.getIdProductOrderInterest(),
                        x.getIdProductDetailsOrder().getIdProductDetailsOrder(),
                        x.getIdInstitution().getId_institution(),
                        x.getName(),
                        x.getPhone(),
                        x.getEmail(),
                        productInterestOperationRepository.findAllByOrderId(x.getIdProductOrderInterest()).stream()
                                .map(y -> new OrderInterestsDTO(y.getItem().getName(), y.getQuantity()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
