package com.ages.doacaobackend.business.mappers;

import com.ages.doacaobackend.business.dto.Item.ItemRequest;
import com.ages.doacaobackend.business.dto.Item.ItemResponse;
import com.ages.doacaobackend.business.entity.Item;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-22T20:26:02-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Item itemRequestToItem(ItemRequest request) {
        if ( request == null ) {
            return null;
        }

        Item item = new Item();

        item.setName( request.getName() );
        item.setLimitItens( request.getLimitItens() );
        item.setUnitMeasurement( request.getUnitMeasurement() );

        return item;
    }

    @Override
    public Item serviceResponseToService(ItemResponse request) {
        if ( request == null ) {
            return null;
        }

        Item item = new Item();

        item.setName( request.getName() );
        item.setLimitItens( request.getLimitItens() );
        item.setUnitMeasurement( request.getUnitMeasurement() );

        return item;
    }

    @Override
    public ItemRequest serviceToServiceRequest(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemRequest itemRequest = new ItemRequest();

        itemRequest.setName( item.getName() );
        itemRequest.setLimitItens( item.getLimitItens() );
        itemRequest.setUnitMeasurement( item.getUnitMeasurement() );

        return itemRequest;
    }

    @Override
    public ItemResponse serviceToServiceResponse(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemResponse itemResponse = new ItemResponse();

        itemResponse.setIdItem( item.getIdItem() );
        itemResponse.setName( item.getName() );
        itemResponse.setLimitItens( item.getLimitItens() );
        itemResponse.setUnitMeasurement( item.getUnitMeasurement() );

        return itemResponse;
    }
}
