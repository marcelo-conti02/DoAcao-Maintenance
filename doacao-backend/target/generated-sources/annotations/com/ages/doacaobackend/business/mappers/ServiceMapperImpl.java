package com.ages.doacaobackend.business.mappers;

import com.ages.doacaobackend.business.dto.Service.ServiceRequest;
import com.ages.doacaobackend.business.dto.Service.ServiceResponse;
import com.ages.doacaobackend.business.entity.Service;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-22T20:26:02-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public Service serviceRequestToService(ServiceRequest request) {
        if ( request == null ) {
            return null;
        }

        Service service = new Service();

        service.setName( request.getName() );
        service.setLimitService( request.getLimitService() );

        return service;
    }

    @Override
    public Service serviceResponseToService(ServiceResponse request) {
        if ( request == null ) {
            return null;
        }

        Service service = new Service();

        service.setId_Service( request.getId_Service() );
        service.setName( request.getName() );
        service.setLimitService( request.getLimitService() );

        return service;
    }

    @Override
    public ServiceRequest serviceToServiceRequest(Service service) {
        if ( service == null ) {
            return null;
        }

        ServiceRequest serviceRequest = new ServiceRequest();

        serviceRequest.setName( service.getName() );
        serviceRequest.setLimitService( service.getLimitService() );

        return serviceRequest;
    }

    @Override
    public ServiceResponse serviceToServiceResponse(Service service) {
        if ( service == null ) {
            return null;
        }

        ServiceResponse serviceResponse = new ServiceResponse();

        serviceResponse.setId_Service( service.getId_Service() );
        serviceResponse.setName( service.getName() );
        serviceResponse.setLimitService( service.getLimitService() );

        return serviceResponse;
    }
}
