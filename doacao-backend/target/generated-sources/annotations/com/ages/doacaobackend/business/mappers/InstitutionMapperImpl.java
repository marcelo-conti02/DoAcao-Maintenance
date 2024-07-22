package com.ages.doacaobackend.business.mappers;

import com.ages.doacaobackend.business.dto.Institution.InstitutionPatchRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionResponse;
import com.ages.doacaobackend.business.dto.User.UserDTO;
import com.ages.doacaobackend.business.entity.Institution;
import com.ages.doacaobackend.business.entity.User;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-22T20:26:01-0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class InstitutionMapperImpl implements InstitutionMapper {

    @Override
    public Institution institutionRequestToInstitution(InstitutionRequest request) {
        if ( request == null ) {
            return null;
        }

        Institution institution = new Institution();

        institution.setName( request.getName() );
        institution.setPhone( request.getPhone() );
        institution.setWhatsapp( request.getWhatsapp() );
        institution.setEmail( request.getEmail() );
        institution.setCnpj( request.getCnpj() );
        institution.setStreet( request.getStreet() );
        institution.setCity( request.getCity() );
        institution.setState( request.getState() );
        institution.setComplement( request.getComplement() );
        institution.setWebsite( request.getWebsite() );
        institution.setSocialMedia( request.getSocialMedia() );
        institution.setOtherSocialMedia( request.getOtherSocialMedia() );
        institution.setDescription( request.getDescription() );
        institution.setCep( request.getCep() );
        institution.setDistrict( request.getDistrict() );

        return institution;
    }

    @Override
    public Institution institutionResponseToInstitution(InstitutionResponse request) {
        if ( request == null ) {
            return null;
        }

        Institution institution = new Institution();

        institution.setId_institution( request.getId_institution() );
        institution.setName( request.getName() );
        institution.setPhone( request.getPhone() );
        institution.setWhatsapp( request.getWhatsapp() );
        institution.setEmail( request.getEmail() );
        institution.setCnpj( request.getCnpj() );
        institution.setStreet( request.getStreet() );
        institution.setCity( request.getCity() );
        institution.setState( request.getState() );
        institution.setCreatedTime( request.getCreatedTime() );
        institution.setId_user( userDTOToUser( request.getId_user() ) );
        institution.setComplement( request.getComplement() );
        institution.setWebsite( request.getWebsite() );
        institution.setSocialMedia( request.getSocialMedia() );
        institution.setOtherSocialMedia( request.getOtherSocialMedia() );
        institution.setDescription( request.getDescription() );
        institution.setCep( request.getCep() );
        institution.setDistrict( request.getDistrict() );
        if ( request.getStatus() != null ) {
            institution.setStatus( Enum.valueOf( GeneralStatus.class, request.getStatus() ) );
        }

        return institution;
    }

    @Override
    public InstitutionRequest institutionPatchRequestTInstitutionRequest(InstitutionPatchRequest request) {
        if ( request == null ) {
            return null;
        }

        InstitutionRequest institutionRequest = new InstitutionRequest();

        institutionRequest.setName( request.getName() );
        institutionRequest.setLogin( request.getLogin() );
        institutionRequest.setPhone( request.getPhone() );
        institutionRequest.setWhatsapp( request.getWhatsapp() );
        institutionRequest.setEmail( request.getEmail() );
        institutionRequest.setPassword( request.getPassword() );

        return institutionRequest;
    }

    @Override
    public InstitutionRequest institutionToInstitutionRequest(Institution institution) {
        if ( institution == null ) {
            return null;
        }

        InstitutionRequest institutionRequest = new InstitutionRequest();

        institutionRequest.setName( institution.getName() );
        institutionRequest.setCnpj( institution.getCnpj() );
        institutionRequest.setPhone( institution.getPhone() );
        institutionRequest.setWhatsapp( institution.getWhatsapp() );
        institutionRequest.setEmail( institution.getEmail() );
        institutionRequest.setStreet( institution.getStreet() );
        institutionRequest.setCity( institution.getCity() );
        institutionRequest.setState( institution.getState() );
        institutionRequest.setComplement( institution.getComplement() );
        institutionRequest.setWebsite( institution.getWebsite() );
        institutionRequest.setSocialMedia( institution.getSocialMedia() );
        institutionRequest.setOtherSocialMedia( institution.getOtherSocialMedia() );
        institutionRequest.setDescription( institution.getDescription() );
        institutionRequest.setCep( institution.getCep() );
        institutionRequest.setDistrict( institution.getDistrict() );

        return institutionRequest;
    }

    @Override
    public InstitutionResponse institutionToInstitutionResponse(Institution institution) {
        if ( institution == null ) {
            return null;
        }

        InstitutionResponse institutionResponse = new InstitutionResponse();

        institutionResponse.setId_institution( institution.getId_institution() );
        institutionResponse.setId_user( userToUserDTO( institution.getId_user() ) );
        institutionResponse.setName( institution.getName() );
        institutionResponse.setPhone( institution.getPhone() );
        institutionResponse.setWhatsapp( institution.getWhatsapp() );
        institutionResponse.setEmail( institution.getEmail() );
        institutionResponse.setCnpj( institution.getCnpj() );
        institutionResponse.setStreet( institution.getStreet() );
        institutionResponse.setCity( institution.getCity() );
        institutionResponse.setState( institution.getState() );
        if ( institution.getStatus() != null ) {
            institutionResponse.setStatus( institution.getStatus().name() );
        }
        institutionResponse.setCreatedTime( institution.getCreatedTime() );
        institutionResponse.setComplement( institution.getComplement() );
        institutionResponse.setWebsite( institution.getWebsite() );
        institutionResponse.setSocialMedia( institution.getSocialMedia() );
        institutionResponse.setOtherSocialMedia( institution.getOtherSocialMedia() );
        institutionResponse.setDescription( institution.getDescription() );
        institutionResponse.setCep( institution.getCep() );
        institutionResponse.setDistrict( institution.getDistrict() );

        return institutionResponse;
    }

    protected User userDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );

        return user;
    }

    protected UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );

        return userDTO;
    }
}
