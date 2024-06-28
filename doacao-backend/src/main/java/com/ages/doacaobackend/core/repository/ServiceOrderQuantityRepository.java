package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Service.ServiceOrderServiceResponse;
import com.ages.doacaobackend.business.dto.Service.ServiceResponse;
import com.ages.doacaobackend.business.dto.ServiceOrder.*;
import com.ages.doacaobackend.business.dto.urgentOrder.UrgentOrderComponentMember;
import com.ages.doacaobackend.business.entity.Institution;
import com.ages.doacaobackend.business.entity.Service;
import com.ages.doacaobackend.business.entity.ServiceDetailsOrder;
import com.ages.doacaobackend.business.entity.ServiceQuantityOrder;
import com.ages.doacaobackend.business.exception.*;
import com.ages.doacaobackend.business.mappers.ServiceMapper;
import com.ages.doacaobackend.core.operation.ServiceOrderQuantityOperationRepository;
import com.ages.doacaobackend.core.service.InstitutionService;
import com.ages.doacaobackend.core.service.ServiceOrderDetailsService;
import com.ages.doacaobackend.core.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ServiceOrderQuantityRepository {

    @Autowired
    ServiceOrderQuantityOperationRepository operationRepository;

    @Autowired
    ServiceOrderDetailsService serviceDetailsService;

    @Autowired
    ServiceService serviceService;

    @Autowired
    InstitutionService institutionService;

    @Autowired
    ServiceMapper serviceMapper;

    public ServiceOrderResponse createServiceOrder(ServiceOrderRequest serviceOrderRequest) throws EntityNotFoundException, ExistingOrderException, DuplicateServiceException, ExcedeedLimitServiceException {

        validateServiceOrder(serviceOrderRequest);

        ServiceDetailsOrder serviceDetailsOrder = serviceDetailsService.createDetailsOrder(serviceOrderRequest);

        List<Service> listServices = new ArrayList<>();
        List<ServiceResponse> listServicesResponse = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        int i = 0;

        for (ServiceQuantityOrderRequest orderRequest : serviceOrderRequest.getServices()) {
            listServices.add(serviceService.findById(orderRequest.getIdService()));

            quantities.add(orderRequest.getQuantitySolicited());
        }

        for (Service service : listServices) {
            ServiceQuantityOrder newServiceQuantityOrder = new ServiceQuantityOrder()
                    .withIdInstitution(serviceDetailsOrder.getIdInstitution())
                    .withIdServiceDetailsOrder(serviceDetailsOrder)
                    .withIdService(service)
                    .withQuantityServiceReceived(0)
                    .withObservations(serviceOrderRequest.getServices().get(i).getDescription())
                    .withQuantityServiceMissing(quantities.get(i).intValue())
                    .withQuantityServiceSolicited(quantities.get(i).intValue());

            operationRepository.save(newServiceQuantityOrder);
            listServicesResponse.add(serviceMapper.serviceToServiceResponse(service));
            i++;
        }

        return new ServiceOrderResponse().withIdServiceDetailsOrder(serviceDetailsOrder.getIdServiceDetailsOrder())
                .withServices(listServicesResponse)
                .withCreatedTime(serviceDetailsOrder.getCreatedTime())
                .withLimitDate(serviceDetailsOrder.getLimitDate())
                .withIsActive(serviceDetailsOrder.getStatus());

    }

    private void validateServiceOrder(ServiceOrderRequest serviceOrderRequest) throws ExistingOrderException, DuplicateServiceException, ExcedeedLimitServiceException {
        if (serviceDetailsService.findDetailsOrder(serviceOrderRequest.getIdInstitution()) > 0)
            throw new ExistingOrderException("Pedido ativo já existente para essa instituição");

        if (serviceOrderRequest.getServices().stream()
                .map(ServiceQuantityOrderRequest::getIdService)
                .distinct().count() != serviceOrderRequest.getServices().size())
            throw new DuplicateServiceException("Serviço duplicado dentro do pedido");

        for (ServiceQuantityOrderRequest quantityOrderRequest : serviceOrderRequest.getServices()) {
            if (serviceService.findById(quantityOrderRequest.getIdService()).getLimitService() < quantityOrderRequest.getQuantitySolicited() && !serviceOrderRequest.isIsUrgent()) {
                throw new ExcedeedLimitServiceException("Solicitado mais serviços do que o limite disponível");
            }

            if (quantityOrderRequest.getQuantitySolicited() < 1) {
                throw new ExcedeedLimitServiceException("Todos os itens devem ter ao menos uma unidade solicitada");
            }
        }
    }

    public List<String> findAllServiceResponseInOrder(int id) {
        return operationRepository.findAll()
                .stream()
                .filter(x -> x.getIdServiceDetailsOrder().getIdServiceDetailsOrder() == id)
                .map(ServiceQuantityOrder::getIdService)
                .map(serviceMapper::serviceToServiceResponse)
                .map(ServiceResponse::getName)
                .collect(Collectors.toList());
    }


    public List<ServiceQuantityOrder> findAllQuantityServiceOrders(int id) {
        return operationRepository.findAll()
                .stream()
                .filter(x -> x.getIdServiceDetailsOrder().getIdServiceDetailsOrder() == id)
                .collect(Collectors.toList());
    }

    public ServiceOrderResponse createUrgetServiceOrder(ServiceOrderRequest serviceOrderRequest) throws EntityNotFoundException, ExistingOrderException, DuplicateServiceException, ExcedeedLimitServiceException, NotUrgentRequestException {

        validateUrgentServiceOrder(serviceOrderRequest);

        ServiceDetailsOrder serviceDetailsOrder = serviceDetailsService.createUrgentDetailsOrder(serviceOrderRequest);

        List<Service> listServices = new ArrayList<>();
        List<ServiceResponse> listServicesResponse = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        int i = 0;

        for (ServiceQuantityOrderRequest orderRequest : serviceOrderRequest.getServices()) {
            listServices.add(serviceService.findById(orderRequest.getIdService()));

            quantities.add(orderRequest.getQuantitySolicited());
        }

        for (Service service : listServices) {
            ServiceQuantityOrder newServiceQuantityOrder = new ServiceQuantityOrder()
                    .withIdInstitution(serviceDetailsOrder.getIdInstitution())
                    .withIdServiceDetailsOrder(serviceDetailsOrder)
                    .withIdService(service)
                    .withQuantityServiceReceived(0)
                    .withQuantityServiceMissing(quantities.get(i).intValue())
                    .withQuantityServiceSolicited(quantities.get(i).intValue());

            operationRepository.save(newServiceQuantityOrder);
            listServicesResponse.add(serviceMapper.serviceToServiceResponse(service));
            i++;
        }

        return new ServiceOrderResponse().withIdServiceDetailsOrder(serviceDetailsOrder.getIdServiceDetailsOrder())
                .withServices(listServicesResponse)
                .withCreatedTime(serviceDetailsOrder.getCreatedTime())
                .withLimitDate(serviceDetailsOrder.getLimitDate())
                .withIsActive(serviceDetailsOrder.getStatus());

    }

    private void validateUrgentServiceOrder(ServiceOrderRequest serviceOrderRequest) throws ExistingOrderException, DuplicateServiceException, ExcedeedLimitServiceException, NotUrgentRequestException {
        if (!serviceOrderRequest.isIsUrgent())
            throw new NotUrgentRequestException("Pedido não é urgente, crie um produto regular");

        if (serviceDetailsService.findUrgentDetailsOrder(serviceOrderRequest.getIdInstitution()) > 0)
            throw new ExistingOrderException("Pedido urgente ativo já existente para essa instituição");

        if (serviceOrderRequest.getServices().stream()
                .map(ServiceQuantityOrderRequest::getIdService)
                .distinct().count() != serviceOrderRequest.getServices().size())
            throw new DuplicateServiceException("Serviço duplicado dentro do pedido");

        for (ServiceQuantityOrderRequest quantityOrderRequest : serviceOrderRequest.getServices()) {

            if (quantityOrderRequest.getQuantitySolicited() < 1) {
                throw new ExcedeedLimitServiceException("Todos os itens devem ter ao menos uma unidade solicitada");
            }
        }
    }

    public List<ServiceOrderServiceResponse> findAllServicesInOrder(int id) {
        return operationRepository.findAll()
                .stream()
                .filter(x -> x.getIdServiceQuantityOrder() == id)
                .map(x -> new ServiceOrderServiceResponse(
                        x.getIdService().getId_Service(),
                        x.getIdService().getName(),
                        x.getQuantityServiceSolicited()))
                .collect(Collectors.toList());
    }

    public List<UrgentOrderComponentMember> findServicesAndQuantitiesFromOrder(int id) {
        return operationRepository.findAll()
                .stream()
                .filter(x -> x.getIdServiceDetailsOrder().getIdServiceDetailsOrder() == id)
                .map(x -> new UrgentOrderComponentMember(
                        x.getQuantityServiceSolicited(),
                        x.getIdService().getName(),
                        null))
                .collect(Collectors.toList());
    }

    private void removeItems(List<ServiceQuantityOrderResponse> editedItems, int orderId) throws EntityNotFoundException {
        ServiceDetailsOrder order = serviceDetailsService.findById(orderId);

        List<Integer> orderItemsIds = operationRepository.findAllIdsByOrderId(order);
        List<Integer> editedItemsIds = editedItems.stream().map(ServiceQuantityOrderResponse::getIdServiceQuantityOrder).collect(Collectors.toList());

        orderItemsIds.stream()
                .filter(id -> !editedItemsIds.contains(id)).forEach(operationRepository::deleteById);
    }

    public ServiceOrderListResponse editServiceOrder(ServiceOrderListResponse editRequest) throws EntityNotFoundException {
        ServiceOrderListResponse dto = new ServiceOrderListResponse();

        List<ServiceQuantityOrderResponse> orderResponse = new ArrayList<>();

        removeItems(editRequest.getServices(), editRequest.getIdServiceOrder());

        for (ServiceQuantityOrderResponse response : editRequest.getServices()) {
            Optional<ServiceQuantityOrder> order = operationRepository.findById(response.getIdServiceQuantityOrder());

            if (order.isPresent()) {
                ServiceQuantityOrder serviceOrder = order.get().withIdServiceQuantityOrder(response.getIdServiceQuantityOrder())
                        .withIdInstitution(response.getIdServiceDetailsOrder().getIdInstitution())
                        .withIdServiceDetailsOrder(response.getIdServiceDetailsOrder())
                        .withIdService(response.getIdService())
                        .withObservations(response.getDescription())
                        .withQuantityServiceReceived(response.getQuantityServiceReceived())
                        .withQuantityServiceMissing(response.getQuantityServiceMissing())
                        .withQuantityServiceSolicited(response.getQuantityServiceSolicited());


                orderResponse.add(new ServiceQuantityOrderResponse(serviceOrder));
                operationRepository.save(serviceOrder);
            } else {
                ServiceQuantityOrder newServiceQuantityOrder = new ServiceQuantityOrder();
                Service service = serviceService.findById(response.getIdService().getId_Service());
                Institution institution = institutionService.getPureInstitution(editRequest.getIdInstitution());

                newServiceQuantityOrder.withIdInstitution(institution)
                        .withIdServiceDetailsOrder(response.getIdServiceDetailsOrder())
                        .withIdService(service)
                        .withObservations(response.getDescription())
                        .withQuantityServiceReceived(response.getQuantityServiceReceived())
                        .withQuantityServiceMissing(response.getQuantityServiceMissing())
                        .withQuantityServiceSolicited(response.getQuantityServiceSolicited());

                orderResponse.add(new ServiceQuantityOrderResponse(newServiceQuantityOrder));
                operationRepository.save(newServiceQuantityOrder);
            }
        }

        dto.withIdServiceOrder(editRequest.getIdServiceOrder())
                .withIdInstitution(editRequest.getIdInstitution())
                .withInstitutionDescription(editRequest.getInstitutionDescription())
                .withInstitutionName(editRequest.getInstitutionName())
                .withIsUrgent(editRequest.getIsUrgent())
                .withCreatedTime(editRequest.getCreatedTime())
                .withLimitDate(editRequest.getLimitDate())
                .withServices(orderResponse);

        return dto;
    }
}
