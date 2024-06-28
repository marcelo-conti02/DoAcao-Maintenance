package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Interest.OrderInterestDTO;
import com.ages.doacaobackend.business.dto.Interest.OrderInterestsDTO;
import com.ages.doacaobackend.business.dto.donation.DonationInterestRequest;
import com.ages.doacaobackend.business.dto.donation.Interest;
import com.ages.doacaobackend.business.entity.ServiceDetailsOrder;
import com.ages.doacaobackend.business.entity.ServiceInterest;
import com.ages.doacaobackend.business.entity.ServiceOrderInterest;
import com.ages.doacaobackend.core.operation.ServiceInterestOperationRepository;
import com.ages.doacaobackend.core.operation.ServiceOperationRepository;
import com.ages.doacaobackend.core.operation.ServiceOrderDetailsOperationRepository;
import com.ages.doacaobackend.core.operation.ServiceOrderInterestOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ServiceInterestRepository {

    @Autowired
    ServiceOrderInterestOperationRepository serviceOrderInterestOperationRepository;

    @Autowired
    ServiceInterestOperationRepository serviceInterestOperationRepository;

    @Autowired
    ServiceOrderDetailsOperationRepository serviceOrderDetailsOperationRepository;

    @Autowired
    ServiceOperationRepository serviceOperationRepository;

    public void createServiceInterest(final DonationInterestRequest request) {
        ServiceOrderInterest serviceOrderInterest = new ServiceOrderInterest();
        ServiceDetailsOrder serviceDetailsOrder = serviceOrderDetailsOperationRepository.findById(request.getOrderId()).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));
        serviceOrderInterest.setServiceDetailsOrder(serviceDetailsOrder);
        serviceOrderInterest.setIdInstitution(serviceDetailsOrder.getIdInstitution());
        serviceOrderInterest.setName(request.getName());
        serviceOrderInterest.setPhone(request.getPhone());
        serviceOrderInterest.setEmail(request.getEmail());
        serviceOrderInterest.setActive("A");
        ServiceOrderInterest persistedServiceOrderInterest = serviceOrderInterestOperationRepository.save(serviceOrderInterest);


        for (Interest service : request.getItemsAndQuantities()) {
            ServiceInterest serviceInterest = new ServiceInterest();
            serviceInterest.setServiceOrderInterest(persistedServiceOrderInterest);
            serviceInterest.setService(serviceOperationRepository.findByName(service.getInterestName()).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada")));
            serviceInterest.setQuantity(service.getAmount());
            serviceInterestOperationRepository.save(serviceInterest);
        }
    }

    public List<OrderInterestDTO> listAllInterestsInOrder(final int id) {
        List<ServiceOrderInterest> serviceOrderInterests = serviceOrderInterestOperationRepository.findAllByOrderId(id);
        if (serviceOrderInterests.isEmpty()) return Collections.emptyList();

        return serviceOrderInterests.stream()
                .map(x -> new OrderInterestDTO(
                        x.getIdInterest(),
                        x.getServiceDetailsOrder().getIdServiceDetailsOrder(),
                        x.getIdInstitution().getId_institution(),
                        x.getName(),
                        x.getPhone(),
                        x.getEmail(),
                        serviceInterestOperationRepository.findAllByOrderId(x.getIdInterest()).stream()
                                .map(y -> new OrderInterestsDTO(y.getService().getName(), y.getQuantity()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
