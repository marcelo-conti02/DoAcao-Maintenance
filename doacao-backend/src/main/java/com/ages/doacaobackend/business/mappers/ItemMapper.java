package com.ages.doacaobackend.business.mappers;

import com.ages.doacaobackend.business.dto.Item.ItemRequest;
import com.ages.doacaobackend.business.dto.Item.ItemResponse;
import com.ages.doacaobackend.business.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ItemMapper {

    Item itemRequestToItem(ItemRequest request);

    Item itemResponseToItem(ItemResponse request);

    ItemRequest itemToItemRequest(Item item);

    ItemResponse itemToItemResponse(Item item);

}
