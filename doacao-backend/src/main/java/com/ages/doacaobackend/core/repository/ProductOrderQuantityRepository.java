package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Item.ItemResponse;
import com.ages.doacaobackend.business.dto.ProductOrder.*;
import com.ages.doacaobackend.business.dto.urgentOrder.UrgentOrderComponentMember;
import com.ages.doacaobackend.business.entity.Item;
import com.ages.doacaobackend.business.entity.ProductDetailsOrder;
import com.ages.doacaobackend.business.entity.ProductQuantityOrder;
import com.ages.doacaobackend.business.exception.*;
import com.ages.doacaobackend.business.mappers.ItemMapper;
import com.ages.doacaobackend.core.operation.ProductOrderQuantityOperationRepository;
import com.ages.doacaobackend.core.service.InstitutionService;
import com.ages.doacaobackend.core.service.ItemService;
import com.ages.doacaobackend.core.service.ProductOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductOrderQuantityRepository {

    @Autowired
    ProductOrderQuantityOperationRepository operationRepository;

    @Autowired
    ProductOrderDetailsService productDetailsService;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    InstitutionService institutionService;

    public ProductOrderResponse createProductOrder(ProductOrderRequest productOrderRequest) throws EntityNotFoundException, ExistingOrderException, DuplicateProductException, ExcedeedLimitProductException, WrongProductUnitMeasurement {

        validateProductOrder(productOrderRequest);

        ProductDetailsOrder productDetailsOrder = productDetailsService.createDetailsOrder(productOrderRequest);

        List<Item> listItens = new ArrayList<>();
        List<ItemResponse> listItensResponse = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        int i = 0;

        for (ProductQuantityOrderRequest orderRequest : productOrderRequest.getItem()) {
            listItens.add(itemService.findById(orderRequest.getIdItem()));

            quantities.add(orderRequest.getQuantitySolicited());
        }

        for (Item item : listItens) {
            ProductQuantityOrder newProductQuantityOrder = new ProductQuantityOrder()
                    .withIdInstitution(productDetailsOrder.getIdInstitution())
                    .withIdProductDetailsOrder(productDetailsOrder)
                    .withIdItem(item)
                    .withQuantityProductsReceived(0)
                    .withObservations(productOrderRequest.getItems().get(i).getDescription())
                    .withQuantityProductsMissing(quantities.get(i).intValue())
                    .withQuantityProductsSolicited(quantities.get(i).intValue());

            operationRepository.save(newProductQuantityOrder);
            listItensResponse.add(itemMapper.itemToItemResponse(item));
            i++;
        }

        return new ProductOrderResponse().withIdProductOrderResponse(productDetailsOrder.getIdProductDetailsOrder())
                .withItens(listItensResponse)
                .withCreatedTime(productDetailsOrder.getCreatedTime())
                .withLimitDate(productDetailsOrder.getLimitDate())
                .withStatus(productDetailsOrder.getStatus());
    }

    private void validateProductOrder(ProductOrderRequest productOrderRequest) throws ExistingOrderException, DuplicateProductException, ExcedeedLimitProductException, EntityNotFoundException, WrongProductUnitMeasurement {
        if (productDetailsService.findDetailsOrder(productOrderRequest.getIdInstitution()) > 0)
            throw new ExistingOrderException("Pedido ativo já existente para essa instituição");

        if (productOrderRequest.getItem().stream()
                .map(ProductQuantityOrderRequest::getIdItem)
                .distinct().count() != productOrderRequest.getItem().size())
            throw new DuplicateProductException("Item duplicado dentro do pedido");

        for (ProductQuantityOrderRequest quantityOrderRequest : productOrderRequest.getItem()) {
            Item item = itemService.findById(quantityOrderRequest.getIdItem());

            if (item.getLimitItens() < quantityOrderRequest.getQuantitySolicited() && !productOrderRequest.isUrgent()) {
                throw new ExcedeedLimitProductException("Solicitado mais itens do que o limite disponível");
            }

            if (quantityOrderRequest.getQuantitySolicited() < 1) {
                throw new ExcedeedLimitProductException("Todos os itens devem ter ao menos uma unidade solicitada");
            }

            if (!Objects.equals(item.getUnitMeasurement(), quantityOrderRequest.getUnitMeasurement())) {
                throw new WrongProductUnitMeasurement("Medida de unidade incorreta");
            }
        }
    }

    public List<ProductQuantityOrder> findAllProductQuantityOrder(int id) {
        return operationRepository.findAll()
                .stream()
                .filter(x -> x.getIdProductDetailsOrder().getIdProductDetailsOrder() == id)
                .collect(Collectors.toList());
    }

    public ProductOrderResponse createUrgentProductOrder(ProductOrderRequest productOrderRequest) throws EntityNotFoundException, ExistingOrderException, DuplicateProductException, ExcedeedLimitProductException, WrongProductUnitMeasurement, NotUrgentRequestException {
        validateUrgentProductOrder(productOrderRequest);
        ProductDetailsOrder productDetailsOrder = productDetailsService.createUrgentDetailsOrder(productOrderRequest);

        List<Item> listItens = new ArrayList<>();
        List<ItemResponse> listItensResponse = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        int i = 0;

        for (ProductQuantityOrderRequest orderRequest : productOrderRequest.getItem()) {
            listItens.add(itemService.findById(orderRequest.getIdItem()));

            quantities.add(orderRequest.getQuantitySolicited());
        }

        for (Item item : listItens) {
            ProductQuantityOrder newProductQuantityOrder = new ProductQuantityOrder()
                    .withIdInstitution(productDetailsOrder.getIdInstitution())
                    .withIdProductDetailsOrder(productDetailsOrder)
                    .withIdItem(item)
                    .withQuantityProductsReceived(0)
                    .withQuantityProductsMissing(quantities.get(i).intValue())
                    .withQuantityProductsSolicited(quantities.get(i).intValue());

            operationRepository.save(newProductQuantityOrder);
            listItensResponse.add(itemMapper.itemToItemResponse(item));
            i++;
        }

        return new ProductOrderResponse().withIdProductOrderResponse(productDetailsOrder.getIdProductDetailsOrder())
                .withItens(listItensResponse)
                .withCreatedTime(productDetailsOrder.getCreatedTime())
                .withLimitDate(productDetailsOrder.getLimitDate())
                .withStatus(productDetailsOrder.getStatus());

    }

    private void validateUrgentProductOrder(ProductOrderRequest productOrderRequest) throws ExistingOrderException, DuplicateProductException, ExcedeedLimitProductException, EntityNotFoundException, WrongProductUnitMeasurement, NotUrgentRequestException {
        if (!productOrderRequest.isUrgent())
            throw new NotUrgentRequestException("Pedido não é urgente, crie um produto regular");

        if (productDetailsService.findUrgentDetailsOrder(productOrderRequest.getIdInstitution()) > 0)
            throw new ExistingOrderException("Pedido urgente ativo já existente para essa instituição");

        if (productOrderRequest.getItem().stream()
                .map(ProductQuantityOrderRequest::getIdItem)
                .distinct().count() != productOrderRequest.getItem().size())
            throw new DuplicateProductException("Item duplicado dentro do pedido");

        for (ProductQuantityOrderRequest quantityOrderRequest : productOrderRequest.getItem()) {
            Item item = itemService.findById(quantityOrderRequest.getIdItem());
            if (quantityOrderRequest.getQuantitySolicited() < 1) {
                throw new ExcedeedLimitProductException("Todos os itens devem ter ao menos uma unidade solicitada");
            }

            if (!Objects.equals(item.getUnitMeasurement(), quantityOrderRequest.getUnitMeasurement())) {
                throw new WrongProductUnitMeasurement("Medida de unidade incorreta");
            }
        }
    }

    public List<String> findAllProductResponseInOrder(int id) {
        return operationRepository.findAll()
                .stream()
                .filter(x -> x.getIdProductDetailsOrder().getIdProductDetailsOrder() == id)
                .map(ProductQuantityOrder::getIdItem)
                .map(itemMapper::itemToItemResponse)
                .map(ItemResponse::getName)
                .collect(Collectors.toList());
    }

    public List<ProductOrderProductResponse> getAllProductsInOrder(int id) {
        return operationRepository.findAll()
                .stream()
                .filter(x -> x.getIdProductDetailsOrder().getIdProductDetailsOrder() == id)
                .map(x -> new ProductOrderProductResponse(
                        x.getIdItem().getIdItem(),
                        x.getIdItem().getName(),
                        x.getQuantityProductsSolicited()))
                .collect(Collectors.toList());
    }

    public List<UrgentOrderComponentMember> findProductsAndQuantitiesFromOrder(int id) {
        return operationRepository.findAll()
                .stream()
                .filter(x -> x.getIdProductDetailsOrder().getIdProductDetailsOrder() == id)
                .map(x -> new UrgentOrderComponentMember(
                        x.getQuantityProductsSolicited(),
                        x.getIdItem().getName(),
                        x.getIdItem().getUnitMeasurement()))
                .collect(Collectors.toList());
    }

    private void removeItems(List<ProductQuantityOrderResponse> editedItems, int orderId) throws EntityNotFoundException {
        ProductDetailsOrder order = productDetailsService.findById(orderId);

        List<Integer> orderItemsIds = operationRepository.findAllIdsByOrderId(order);
        List<Integer> editedItemsIds = editedItems.stream().map(ProductQuantityOrderResponse::getIdProductQuantityOrder).collect(Collectors.toList());

        orderItemsIds.stream()
                .filter(id -> !editedItemsIds.contains(id)).forEach(operationRepository::deleteById);
    }

    public ProductOrderListResponse editProductOrder(ProductOrderListResponse editRequest) throws EntityNotFoundException {
        ProductOrderListResponse dto = new ProductOrderListResponse();
        List<ProductQuantityOrderResponse> orderResponse = new ArrayList<>();

        removeItems(editRequest.getItens(), editRequest.getIdProductOrder());

        for (ProductQuantityOrderResponse response : editRequest.getItens()) {
            if (response.getIdProductQuantityOrder() != 0) {
                Optional<ProductQuantityOrder> order = operationRepository.findById(response.getIdProductQuantityOrder());

                if (order.isPresent()) {
                    order.get().withIdProductQuantityOrder(response.getIdProductQuantityOrder())
                            .withIdProductDetailsOrder(response.getIdProductDetailsOrder())
                            .withIdItem(response.getIdItem())
                            .withObservations(response.getDescription())
                            .withQuantityProductsReceived(response.getQuantityProductsReceived())
                            .withQuantityProductsMissing(response.getQuantityProductsMissing())
                            .withQuantityProductsSolicited(response.getQuantityProductsSolicited());

                    orderResponse.add(new ProductQuantityOrderResponse(order.get()));
                    operationRepository.save(order.get());
                }
            } else {
                ProductQuantityOrder newProductQuantityOrder = new ProductQuantityOrder();
                Item item = itemService.findById(response.getIdItem().getIdItem());

                newProductQuantityOrder.withIdInstitution(institutionService.getPureInstitution(editRequest.getIdInstitution()))
                        .withIdProductDetailsOrder(response.getIdProductDetailsOrder())
                        .withIdItem(item)
                        .withObservations(response.getDescription())
                        .withQuantityProductsReceived(response.getQuantityProductsReceived())
                        .withQuantityProductsMissing(response.getQuantityProductsMissing())
                        .withQuantityProductsSolicited(response.getQuantityProductsSolicited());

                orderResponse.add(new ProductQuantityOrderResponse(newProductQuantityOrder));
                operationRepository.save(newProductQuantityOrder);
            }
        }

        dto.withIdProductOrder(editRequest.getIdProductOrder())
                .withIdInstitution(editRequest.getIdInstitution())
                .withInstitutionDescription(editRequest.getInstitutionDescription())
                .withInstitutionName(editRequest.getInstitutionName())
                .withIsUrgent(editRequest.getIsUrgent())
                .withCreatedTime(editRequest.getCreatedTime())
                .withLimitDate(editRequest.getLimitDate())
                .withItens(orderResponse);

        return dto;
    }
}
