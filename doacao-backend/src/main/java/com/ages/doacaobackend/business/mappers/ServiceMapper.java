
package com.ages.doacaobackend.business.mappers;

import com.ages.doacaobackend.business.dto.Service.ServiceRequest;
import com.ages.doacaobackend.business.dto.Service.ServiceResponse;
import com.ages.doacaobackend.business.entity.Service;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
public interface ServiceMapper {
    
    Service serviceRequestToService(ServiceRequest request);
    Service serviceResponseToService(ServiceResponse request);
    ServiceRequest serviceToServiceRequest(Service service);
    ServiceResponse serviceToServiceResponse(Service service);
}
