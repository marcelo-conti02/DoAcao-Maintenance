package com.ages.doacaobackend.controller;

import com.ages.doacaobackend.business.dto.Item.ItemRequest;
import com.ages.doacaobackend.business.dto.Item.ItemResponse;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.ItemLimitLessThanOneException;
import com.ages.doacaobackend.core.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemResponse>> listItens() {
        return ok(itemService.listItens());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ItemResponse> getItem(@PathVariable final String uuid)
            throws EntityNotFoundException {
        return ok(itemService.getItem(uuid));
    }

    @PostMapping
    public ResponseEntity<ItemResponse> createItem(@RequestBody ItemRequest request)
            throws ItemLimitLessThanOneException {
        return new ResponseEntity<ItemResponse>(itemService.createItem(request),
                HttpStatus.CREATED);
    }
    
}
