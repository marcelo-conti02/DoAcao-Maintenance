package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Item.ItemRequest;
import com.ages.doacaobackend.business.dto.Item.ItemResponse;
import com.ages.doacaobackend.business.entity.Item;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.ItemLimitLessThanOneException;
import com.ages.doacaobackend.business.mappers.ItemMapper;
import com.ages.doacaobackend.core.operation.ItemOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ages.doacaobackend.controller.handler.logMessages.ErrorMessages.ITEM_LIMIT_LESS_ONE;

@Repository
public class ItemRepository {

    @Autowired
    ItemOperationRepository operationRepository;

    @Autowired
    ItemMapper mapper;

    public ItemResponse getItem(String uuid) throws EntityNotFoundException {
        Optional<Item> item = operationRepository.findById(Integer.parseInt(uuid));

        if (!item.isPresent())
            throw new EntityNotFoundException(uuid);

        return mapper.itemToItemResponse(item.get());
    }

    public List<ItemResponse> listItens() {
        List<Item> itens = operationRepository.findAll();
        List<ItemResponse> response = new ArrayList<>();

        itens = itens.stream()
                .sorted(Comparator.comparing(Item::getName))
                .collect(Collectors.toList());

        for (Item item : itens) {
            response.add(mapper.itemToItemResponse(item));
        }

        return response;
    }

    public Item findById(int id) throws EntityNotFoundException {
        Optional<Item> item = operationRepository.findById(id);

        if (!item.isPresent()) throw new EntityNotFoundException(String.valueOf(id));
        return item.get();
    }

    public ItemResponse createItem(ItemRequest request) throws ItemLimitLessThanOneException {
        if (request.getLimitItens() <= 0)
            throw new ItemLimitLessThanOneException(String.format(ITEM_LIMIT_LESS_ONE, request.getLimitItens()));

        Item item = new Item().withLimitItens(request.getLimitItens())
                .withName(request.getName())
                .withUnitMeasurement(request.getUnitMeasurement());

        operationRepository.save(item);

        return mapper.itemToItemResponse(item);
    }

}
