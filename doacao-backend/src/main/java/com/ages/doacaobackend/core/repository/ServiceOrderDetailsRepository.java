package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderListResponse;
import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderResponse;
import com.ages.doacaobackend.business.dto.ProductOrder.ProductQuantityOrderResponse;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderListResponse;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceOrderRequest;
import com.ages.doacaobackend.business.dto.ServiceOrder.ServiceQuantityOrderResponse;
import com.ages.doacaobackend.business.entity.*;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.operation.ServiceOrderDetailsOperationRepository;
import com.ages.doacaobackend.core.service.InstitutionService;
import com.ages.doacaobackend.core.service.ServiceOrderQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ServiceOrderDetailsRepository {
    
    @Autowired
    ServiceOrderDetailsOperationRepository operationRepository;

    @Autowired
    InstitutionService institutionService;

    @Autowired
    ServiceOrderQuantityService quantityService;


    public ServiceDetailsOrder createDetailsOrder(ServiceOrderRequest serviceOrderRequest) throws EntityNotFoundException {

        Institution institution = institutionService.getPureInstitution(serviceOrderRequest.getIdInstitution());


        ServiceDetailsOrder dto = new ServiceDetailsOrder().withIdInstitution(institution)
            .withIsUrgent(serviceOrderRequest.getIsUrgent())
            .withCreatedTime(LocalDateTime.now())
            .withLimitDate(LocalDateTime.now().plusDays(30))
            .withStatus(GeneralStatus.A)
            .withDescription(null);

        operationRepository.save(dto);

        return dto;
    }

    public Institution getInstitutionIdFromOrder(int id) {
        return operationRepository.findById(id).get().getIdInstitution();
    }

    public ServiceDetailsOrder createUrgentDetailsOrder(ServiceOrderRequest serviceOrderRequest) throws EntityNotFoundException {

        Institution institution = institutionService.getPureInstitution(serviceOrderRequest.getIdInstitution());

        List<ServiceDetailsOrder> listDetailsOrders = operationRepository.findAll();

        listDetailsOrders = listDetailsOrders.stream().filter(x -> x.getStatus() == GeneralStatus.P &&
                                                                    x.getIsUrgent() &&
                                                                    x.getIdInstitution().getId_institution() == institution.getId_institution())
                                                        .collect(Collectors.toList());

        for(ServiceDetailsOrder order : listDetailsOrders) {
            order.setStatus(GeneralStatus.I);
            operationRepository.save(order);
        }

        ServiceDetailsOrder dto = new ServiceDetailsOrder().withIdInstitution(institution)
            .withIsUrgent(serviceOrderRequest.getIsUrgent())
            .withCreatedTime(LocalDateTime.now())
            .withLimitDate(LocalDateTime.now().plusDays(30))
            .withStatus(GeneralStatus.P)
            .withDescription(serviceOrderRequest.getDescription());

        operationRepository.save(dto);

        return dto;
    }


    public int findDetailsOrder(int institutionId) {
        List<ServiceDetailsOrder> listDetailsOrders = operationRepository.findAll();

        listDetailsOrders = listDetailsOrders.stream().filter(x -> x.getStatus() == GeneralStatus.A &&
                                                                  !x.getIsUrgent() &&
                                                                   x.getIdInstitution().getId_institution() == institutionId).collect(Collectors.toList());

        return listDetailsOrders.size();
    }

    public int findUrgentDetailsOrder(int institutionId) {
        List<ServiceDetailsOrder> listDetailsOrders = operationRepository.findAll();

        listDetailsOrders = listDetailsOrders.stream().filter(x -> x.getStatus() == GeneralStatus.A &&
                                                                   x.getIsUrgent() &&
                                                                   x.getIdInstitution().getId_institution() == institutionId).collect(Collectors.toList());

        return listDetailsOrders.size();
    }

    public List<ServiceOrderListResponse> findAll(){
        List<ServiceDetailsOrder> listServiceDetailsOrder = operationRepository.findAll().stream().filter(x -> x.getStatus() == GeneralStatus.A).collect(Collectors.toList());
        List<ServiceQuantityOrder> listServiceQuantityOrder = new ArrayList<>();
        List<ServiceOrderListResponse> serviceOrderListResponse = new ArrayList<>();

        for(ServiceDetailsOrder serviceDetailsOrder : listServiceDetailsOrder) {
            listServiceQuantityOrder.addAll(quantityService.findAllQuantityServiceOrders(serviceDetailsOrder.getIdServiceDetailsOrder()));
        }

        for(ServiceDetailsOrder serviceDetailsOrder : listServiceDetailsOrder) {
            serviceOrderListResponse.add(new ServiceOrderListResponse()
                .withIdServiceOrder(serviceDetailsOrder.getIdServiceDetailsOrder())
                .withIdInstitution(serviceDetailsOrder.getIdInstitution().getId_institution())
                .withInstitutionName(serviceDetailsOrder.getIdInstitution().getName())
                .withInstitutionDescription(serviceDetailsOrder.getIdInstitution().getDescription())
                .withIsUrgent(serviceDetailsOrder.getIsUrgent())
                .withCreatedTime(serviceDetailsOrder.getCreatedTime())
                .withLimitDate(serviceDetailsOrder.getLimitDate())
                .withServices(listServiceQuantityOrder.stream()
                     .filter(x ->
                         x.getIdServiceDetailsOrder().getStatus() == GeneralStatus.A &&
                         x.getIdServiceDetailsOrder().getIdServiceDetailsOrder() == serviceDetailsOrder.getIdServiceDetailsOrder())
                    .collect(Collectors.toList())
                    .stream()
                    .map(x -> new ServiceQuantityOrderResponse(x))
                    .collect(Collectors.toList())));
        }

        return serviceOrderListResponse;
    }


    public List<ServiceDetailsOrder> findAllAnalysisUrgentOrders() {
        return operationRepository.findAllAnalysisUrgentOrders();
    }

    public void updateStatus(GeneralStatus status, int orderId) {
        operationRepository.updateStatusById(status, orderId);
    }

    public List<ServiceOrderListResponse> findActivesByInstitution(int idInstitution) {
        List<ServiceDetailsOrder> listServiceDetailsOrder = operationRepository.findAll();
        listServiceDetailsOrder = listServiceDetailsOrder.stream()
                .filter(x -> x.getStatus() == GeneralStatus.A && x.getIdInstitution().getId_institution() == idInstitution)
                .collect(Collectors.toList());
        List<ServiceQuantityOrder> listServiceQuantityOrder = new ArrayList<>();
        List<ServiceOrderListResponse> serviceOrderListResponse = new ArrayList<>();
        for(ServiceDetailsOrder serviceDetailsOrder : listServiceDetailsOrder) {
            listServiceQuantityOrder.addAll(quantityService.findAllQuantityServiceOrders(serviceDetailsOrder.getIdServiceDetailsOrder()));
        }

        for (ServiceDetailsOrder productDetailsOrder: listServiceDetailsOrder) {
            serviceOrderListResponse.add(new ServiceOrderListResponse().withIdServiceOrder(productDetailsOrder.getIdServiceDetailsOrder())
                    .withIdInstitution(productDetailsOrder.getIdInstitution().getId_institution())
                    .withInstitutionName(productDetailsOrder.getIdInstitution().getName())
                    .withInstitutionDescription(productDetailsOrder.getIdInstitution().getDescription())
                    .withIsUrgent(productDetailsOrder.getIsUrgent())
                    .withCreatedTime(productDetailsOrder.getCreatedTime())
                    .withLimitDate(productDetailsOrder.getLimitDate())
                    .withItens(listServiceQuantityOrder.stream()
                            .filter(x ->
                                    x.getIdServiceDetailsOrder().getStatus() == GeneralStatus.A &&
                                            x.getIdServiceDetailsOrder().getIdServiceDetailsOrder() == productDetailsOrder.getIdServiceDetailsOrder())
                            .collect(Collectors.toList())
                            .stream()
                            .map(x -> new ServiceQuantityOrderResponse(x))
                            .collect(Collectors.toList())));
        }
        return serviceOrderListResponse;
    }

    public ServiceDetailsOrder findById(int orderId) throws EntityNotFoundException {
        return operationRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
    }

    public List<ServiceOrderListResponse> findAllByInstitutionCity(String city) {
        List<ServiceDetailsOrder> listServiceDetailsOrder = operationRepository.findAllByInstitutionCity(city).stream().filter(x -> x.getStatus() == GeneralStatus.A).collect(Collectors.toList());
        List<ServiceQuantityOrder> listServiceQuantityOrder = new ArrayList<>();
        List<ServiceOrderListResponse> serviceOrderListResponse = new ArrayList<>();

        for(ServiceDetailsOrder serviceDetailsOrder : listServiceDetailsOrder) {
            listServiceQuantityOrder.addAll(quantityService.findAllQuantityServiceOrders(serviceDetailsOrder.getIdServiceDetailsOrder()));
        }

        for(ServiceDetailsOrder serviceDetailsOrder : listServiceDetailsOrder) {
            serviceOrderListResponse.add(new ServiceOrderListResponse()
                .withIdServiceOrder(serviceDetailsOrder.getIdServiceDetailsOrder())
                .withIdInstitution(serviceDetailsOrder.getIdInstitution().getId_institution())
                .withInstitutionName(serviceDetailsOrder.getIdInstitution().getName())
                .withInstitutionDescription(serviceDetailsOrder.getIdInstitution().getDescription())
                .withIsUrgent(serviceDetailsOrder.getIsUrgent())
                .withCreatedTime(serviceDetailsOrder.getCreatedTime())
                .withLimitDate(serviceDetailsOrder.getLimitDate())
                .withServices(listServiceQuantityOrder.stream()
                     .filter(x ->
                         x.getIdServiceDetailsOrder().getStatus() == GeneralStatus.A &&
                         x.getIdServiceDetailsOrder().getIdServiceDetailsOrder() == serviceDetailsOrder.getIdServiceDetailsOrder())
                    .collect(Collectors.toList())
                    .stream()
                    .map(x -> new ServiceQuantityOrderResponse(x))
                    .collect(Collectors.toList())));
        }

        return serviceOrderListResponse;
    }
}
