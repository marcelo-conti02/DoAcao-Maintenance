package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderListResponse;
import com.ages.doacaobackend.business.dto.ProductOrder.ProductOrderRequest;
import com.ages.doacaobackend.business.dto.ProductOrder.ProductQuantityOrderResponse;
import com.ages.doacaobackend.business.entity.Institution;
import com.ages.doacaobackend.business.entity.ProductDetailsOrder;
import com.ages.doacaobackend.business.entity.ProductQuantityOrder;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.operation.ProductOrderDetailsOperationRepository;
import com.ages.doacaobackend.core.service.InstitutionService;
import com.ages.doacaobackend.core.service.ProductOrderQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class ProductOrderDetailsRepository {

    @Autowired
    ProductOrderDetailsOperationRepository operationRepository;

    @Autowired
    InstitutionService institutionService;

    @Autowired
    ProductOrderQuantityService quantityService;

    public ProductDetailsOrder createDetailsOrder(ProductOrderRequest request) throws EntityNotFoundException {
        Institution institution = institutionService.getPureInstitution(request.getIdInstitution());

        ProductDetailsOrder dto = new ProductDetailsOrder().withIdInstitution(institution)
                .withIsUrgent(request.isUrgent())
                .withCreatedDate(LocalDateTime.now())
                .withLimitDate(LocalDateTime.now().plusDays(30))
                .witStatus(GeneralStatus.A)
                .withDescription(null);

        return operationRepository.save(dto);
    }

    public Institution getInstitutionFromOrderId(int id) {
        Optional<ProductDetailsOrder> order = operationRepository.findById(id);
        return order.isPresent() ? order.get().getIdInstitution() : null;
    }

    public int findDetailsOrder(int institutionId) {
        List<ProductDetailsOrder> listDetailsOrders = operationRepository.findAll();

        listDetailsOrders = listDetailsOrders.stream().filter(x -> x.getStatus() == GeneralStatus.A &&
                !x.getIsUrgent() &&
                x.getIdInstitution().getId_institution() == institutionId).collect(Collectors.toList());

        return listDetailsOrders.size();
    }

    public int findUrgentDetailsOrder(int institutionId) {
        List<ProductDetailsOrder> listDetailsOrders = operationRepository.findAll();

        listDetailsOrders = listDetailsOrders.stream().filter(x -> x.getStatus() == GeneralStatus.A &&
                x.getIsUrgent() && 
                x.getIdInstitution().getId_institution() == institutionId).collect(Collectors.toList());

        return listDetailsOrders.size();
    }

    public List<ProductOrderListResponse> findAll() {
        List<ProductDetailsOrder> listProductDetailsOrder = operationRepository.findAll();
        listProductDetailsOrder = listProductDetailsOrder.stream().filter(x -> x.getStatus() == GeneralStatus.A).collect(Collectors.toList());
        List<ProductQuantityOrder> listProductQuantityOrder = new ArrayList<>();
        List<ProductOrderListResponse> productOrderListResponse = new ArrayList<>();

        for (ProductDetailsOrder productDetailsOrder : listProductDetailsOrder) {
            listProductQuantityOrder.addAll(quantityService.findAllProductQuantityOrder(productDetailsOrder.getIdProductDetailsOrder()));
        }

        for (ProductDetailsOrder productDetailsOrder : listProductDetailsOrder) {
            productOrderListResponse.add(new ProductOrderListResponse().withIdProductOrder(productDetailsOrder.getIdProductDetailsOrder())
                .withIdInstitution(productDetailsOrder.getIdInstitution().getId_institution())
                .withInstitutionName(productDetailsOrder.getIdInstitution().getName())
                .withInstitutionDescription(productDetailsOrder.getIdInstitution().getDescription())
                .withIsUrgent(productDetailsOrder.getIsUrgent())
                .withCreatedTime(productDetailsOrder.getCreatedTime())
                .withLimitDate(productDetailsOrder.getLimitDate())
                .withItens(listProductQuantityOrder.stream()
                        .filter(x ->
                                x.getIdProductDetailsOrder().getStatus() == GeneralStatus.A &&
                                 x.getIdProductDetailsOrder().getIdProductDetailsOrder() == productDetailsOrder.getIdProductDetailsOrder())
                        .collect(Collectors.toList())
                        .stream()
                        .map(x -> new ProductQuantityOrderResponse().fromEntity(x))
                        .collect(Collectors.toList())));
        }

        return productOrderListResponse;
    }

    public ProductDetailsOrder createUrgentDetailsOrder(ProductOrderRequest request) throws EntityNotFoundException {
        Institution institution = institutionService.getPureInstitution(request.getIdInstitution());

        List<ProductDetailsOrder> listDetailsOrders = operationRepository.findAll();

        listDetailsOrders = listDetailsOrders.stream().filter(x -> x.getStatus() == GeneralStatus.P &&
                                                                    x.getIsUrgent() && 
                                                                    x.getIdInstitution().getId_institution() == institution.getId_institution())
                                                        .collect(Collectors.toList());   
                
        for(ProductDetailsOrder order : listDetailsOrders) {
            order.setStatus(GeneralStatus.I);
            operationRepository.save(order);
        }

        ProductDetailsOrder dto = new ProductDetailsOrder().withIdInstitution(institution)
                .withIsUrgent(request.isUrgent())
                .withCreatedDate(LocalDateTime.now())
                .withLimitDate(LocalDateTime.now().plusDays(30))
                .witStatus(GeneralStatus.P)
                .withDescription(request.getDescription());

        return operationRepository.save(dto);
    }

    public List<ProductDetailsOrder> findAllAnalysisUrgentOrders() {
        return operationRepository.findAllAnalysisUrgentOrders();
    }

    public void updateStatus(GeneralStatus status, int orderId) {
        operationRepository.updateStatusById(status, orderId);
    }
    
    public List<ProductOrderListResponse> findActivesByInstitution(int idInstitution) {
        List<ProductDetailsOrder> listProductDetailsOrder = operationRepository.findAll();
        listProductDetailsOrder = listProductDetailsOrder.stream()
                .filter(x -> x.getStatus() == GeneralStatus.A && x.getIdInstitution().getId_institution() == idInstitution)
                .collect(Collectors.toList());
        List<ProductQuantityOrder> listProductQuantityOrder = new ArrayList<>();
        List<ProductOrderListResponse> productOrderListResponse = new ArrayList<>();
        for (ProductDetailsOrder productDetailsOrder : listProductDetailsOrder) {
            listProductQuantityOrder.addAll(quantityService.findAllProductQuantityOrder(productDetailsOrder.getIdProductDetailsOrder()));
        }

        for (ProductDetailsOrder productDetailsOrder: listProductDetailsOrder) {
            productOrderListResponse.add(new ProductOrderListResponse().withIdProductOrder(productDetailsOrder.getIdProductDetailsOrder())
                    .withIdInstitution(productDetailsOrder.getIdInstitution().getId_institution())
                    .withInstitutionName(productDetailsOrder.getIdInstitution().getName())
                    .withInstitutionDescription(productDetailsOrder.getIdInstitution().getDescription())
                    .withIsUrgent(productDetailsOrder.getIsUrgent())
                    .withCreatedTime(productDetailsOrder.getCreatedTime())
                    .withLimitDate(productDetailsOrder.getLimitDate())
                    .withItens(listProductQuantityOrder.stream()
                            .filter(x ->
                                    x.getIdProductDetailsOrder().getStatus() == GeneralStatus.A &&
                                            x.getIdProductDetailsOrder().getIdProductDetailsOrder() == productDetailsOrder.getIdProductDetailsOrder())
                            .collect(Collectors.toList())
                            .stream()
                            .map(x -> new ProductQuantityOrderResponse(x))
                            .collect(Collectors.toList())));
        }

        return productOrderListResponse;
    }

    public ProductDetailsOrder findById(int orderId) throws EntityNotFoundException {
        return operationRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
    }

    public String findCityByOrderId(int orderId) {
        ProductDetailsOrder order = operationRepository.findById(orderId).orElse(null);
        return order != null ? order.getIdInstitution().getCity() : null;
    }

    public List<ProductDetailsOrder> findAllByInstitutionCity(String city) {
        return operationRepository.findAllByInstitutionCity(city);
    }
}
