package com.ages.doacaobackend.business.mappers;

import com.ages.doacaobackend.business.dto.Institution.InstitutionPatchRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionResponse;
import com.ages.doacaobackend.business.entity.Institution;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface InstitutionMapper {
    
    Institution institutionRequestToInstitution(InstitutionRequest request);

    Institution institutionResponseToInstitution(InstitutionResponse request);

    InstitutionRequest institutionPatchRequestTInstitutionRequest(InstitutionPatchRequest request);
    
    InstitutionRequest institutionToInstitutionRequest(Institution institution);

    InstitutionResponse institutionToInstitutionResponse(Institution institution);

}