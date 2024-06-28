package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.Interest.OrderInterestDTO;
import com.ages.doacaobackend.business.dto.donation.DonationInterestRequest;
import com.ages.doacaobackend.core.repository.ProductInterestRepository;
import com.ages.doacaobackend.core.repository.ServiceInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInterestService {

    @Autowired
    ProductInterestRepository productRepository;

    @Autowired
    ServiceInterestRepository serviceRepository;

    public void saveProductOrderInterest(final DonationInterestRequest request) {
        productRepository.createServiceInterest(request);
    }

    public void saveServiceOrderInterest(final DonationInterestRequest request) {
        serviceRepository.createServiceInterest(request);
    }

    public List<OrderInterestDTO> listAllProductInterestsInOrder(final int id)  {
        return productRepository.listAllInterestsInOrder(id);
    }

    public List<OrderInterestDTO> listAllServiceInterestsInOrder(final int id) {
        return serviceRepository.listAllInterestsInOrder(id);
    }

}
