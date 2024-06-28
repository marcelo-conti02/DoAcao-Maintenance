package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.Item.ItemRequest;
import com.ages.doacaobackend.business.dto.Item.ItemResponse;
import com.ages.doacaobackend.business.entity.Item;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.ItemLimitLessThanOneException;
import com.ages.doacaobackend.core.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public ItemResponse getItem(String uuid) throws EntityNotFoundException {
        return itemRepository.getItem(uuid);
    }

    public List<ItemResponse> listItens() {
        return itemRepository.listItens();
    }

    public ItemResponse createItem(ItemRequest request) throws ItemLimitLessThanOneException {
        return itemRepository.createItem(request);
    }

    public Item findById(int id) throws EntityNotFoundException {
        return itemRepository.findById(id);
    }
}
