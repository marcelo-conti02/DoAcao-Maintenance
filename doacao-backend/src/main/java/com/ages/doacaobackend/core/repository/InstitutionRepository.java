package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.dto.Institution.InstitutionEditStatusRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionPatchRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionResponse;
import com.ages.doacaobackend.business.dto.User.UserRequest;
import com.ages.doacaobackend.business.entity.Institution;
import com.ages.doacaobackend.business.entity.User;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.ExistingCNPJException;
import com.ages.doacaobackend.business.exception.ExistingUserException;
import com.ages.doacaobackend.business.exception.MalformedEntityException;
import com.ages.doacaobackend.business.mappers.InstitutionMapper;
import com.ages.doacaobackend.core.messaging.EmailSender;
import com.ages.doacaobackend.core.operation.InstitutionOperationRepository;
import com.ages.doacaobackend.core.service.AdminService;
import com.ages.doacaobackend.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ages.doacaobackend.controller.handler.logMessages.ErrorMessages.*;
import static com.ages.doacaobackend.core.messaging.EmailMessages.*;

@Repository
public class InstitutionRepository {

    @Autowired
    InstitutionOperationRepository operationRepository;

    @Autowired
    InstitutionMapper mapper;

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    EmailSender sender;

    public InstitutionResponse getInstitution(String uuid) throws EntityNotFoundException {
        Optional<Institution> institution = operationRepository.findById(Integer.parseInt(uuid));

        if(!institution.isPresent()) throw new EntityNotFoundException(uuid);

        return mapper.institutionToInstitutionResponse(institution.get());
    }

    public List<InstitutionResponse> listInstitutions() {
        List<Institution> institutions = operationRepository.findAll();
        List<InstitutionResponse> response = new ArrayList<>();

        institutions = institutions.stream().filter(i -> i.getStatus() == GeneralStatus.A)
                                            .sorted(Comparator.comparing(Institution::getId_institution))
                                            .collect(Collectors.toList());

        for (Institution inst : institutions) {
            response.add(mapper.institutionToInstitutionResponse(inst));
        }

        return response;
    }

    public List<InstitutionResponse> listInstitutionsMock() {
        List<InstitutionResponse> response = new ArrayList<>();

        InstitutionResponse dto1 = new InstitutionResponse().withId_Institution(1)
                                                    .withName("Teste");

        InstitutionResponse dto2 = new InstitutionResponse().withId_Institution(2)
                                                    .withName("Teste 2");

        response.add(dto1);
        response.add(dto2);

        return response;
    }

    public InstitutionResponse createInstitution(InstitutionRequest request) throws EntityNotFoundException, ExistingCNPJException, MalformedEntityException, ExistingUserException {
        validateRequest(request);
        
        UserRequest newUser = new UserRequest().withLogin(request.getLogin())
                                               .withPassword(request.getPassword());

        User userId = userService.createUser(newUser);


        Institution institution = new Institution()
                                      .withName(request.getName())
                                      .withCnpj(request.getCnpj())
                                      .withPhone(request.getPhone())
                                      .withId_user(userId)
                                      .withEmail(request.getEmail())
                                      .withWhatsapp(request.getWhatsapp())
                                      .withStreet(request.getStreet())
                                      .withCity(request.getCity())
                                      .withState(request.getState())
                                      .withStatus(GeneralStatus.P)
                                      .withCreatedTime(LocalDateTime.now())
                                      .withComplement(request.getComplement())
                                      .withWebsite(request.getWebsite())
                                      .withSocialMedia(request.getSocialMedia())
                                      .withOtherSocialMedia(request.getOtherSocialMedia())
                                      .withDescription(request.getDescription())
                                      .withCep(request.getCep())
                                      .withDistrict(request.getDistrict());


        operationRepository.save(institution);

        System.out.println("institution created");

        for(AdminDTO admin : adminService.getAll()) {
            sender.sendEmail(
                NOTIFY_ADMIN_NEW_INSTITUTION_REQUEST_MESSAGE,
                NOTIFY_ADMIN_NEW_INSTITUTION_REQUEST_SUBJECT,
                admin.getEmail()
            );
        }
        
        return mapper.institutionToInstitutionResponse(institution);
    }

    public void patchInstitution(InstitutionPatchRequest request, String uuid) throws EntityNotFoundException {
        Optional<Institution> inst = operationRepository.findById(Integer.parseInt(uuid));

        if (!inst.isPresent()) throw new EntityNotFoundException(uuid);

        Institution institution = inst.get();

        institution = mapper.institutionRequestToInstitution(mapper.institutionPatchRequestTInstitutionRequest(request));

        operationRepository.save(institution);
        System.out.println("institution edited");
    }

    public Institution findByUser(int id) {
        return operationRepository.findByUser(id);
    }

    public List<InstitutionResponse> listPendingInstitutions() {
        List<Institution> institutions = operationRepository.findAll();
        List<InstitutionResponse> response = new ArrayList<>();

        institutions = institutions.stream().filter(i -> i.getStatus() == GeneralStatus.P)
                                            .sorted(Comparator.comparing(Institution::getCreatedTime).reversed())
                                            .collect(Collectors.toList());

        for (Institution inst : institutions) {
            response.add(mapper.institutionToInstitutionResponse(inst));
        }

        return response;
    }

    public void editStatusRequest(InstitutionEditStatusRequest editStatusRequest) throws EntityNotFoundException {
        Optional<Institution> inst = operationRepository.findById(editStatusRequest.getId());
        if (!inst.isPresent()) {
            throw new EntityNotFoundException(editStatusRequest.getId().toString());
        }

        Institution institution = inst.get();
        institution.setStatus(GeneralStatus.valueOf(editStatusRequest.getStatus()));
        operationRepository.save(institution);

        sender.sendEmail(
            STATUS_UPDATE_MESSAGE + institution.getStatus().getStatus(), 
            STATUS_UPDATE_SUBJECT,
            institution.getEmail()
         );

    }

    public Institution getPureInstitution(int id) throws EntityNotFoundException {
        Optional<Institution> institution = operationRepository.findById(id);

        if(!institution.isPresent()) throw new EntityNotFoundException(String.valueOf(id));

        return institution.get();
    }

    private void validateRequest(InstitutionRequest request) throws ExistingCNPJException, ExistingUserException {
        List<AdminDTO> admins = adminService.getAll();
        List<Institution> institutions = operationRepository.findAll();

        for(AdminDTO a : admins) {
            if(a.getEmail().equals(request.getEmail())) throw new ExistingUserException(String.format(EXISTING_USER, request.getEmail()));
        }

        for(Institution i : institutions) {
            if(i.getEmail().equals(request.getEmail())) throw new ExistingUserException(String.format(EXISTING_USER, request.getEmail()));
        }

        if (operationRepository.findByCNPJ(request.getCnpj()).isPresent()) throw new ExistingCNPJException(String.format(EXISTING_CNPJ, request.getCnpj()));


    }

    public List<String> listInstitutionCities() {
        return operationRepository.findAll().stream()
                .map(Institution::getCity)
                .distinct()
                .collect(Collectors.toList());
    }
}
