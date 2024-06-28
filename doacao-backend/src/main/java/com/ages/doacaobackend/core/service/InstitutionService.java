package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.Institution.InstitutionEditStatusRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionPatchRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionResponse;
import com.ages.doacaobackend.business.entity.Institution;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.ExistingCNPJException;
import com.ages.doacaobackend.business.exception.ExistingUserException;
import com.ages.doacaobackend.business.exception.MalformedEntityException;
import com.ages.doacaobackend.core.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ages.doacaobackend.business.validation.FieldValidator.validateFields;

@Service
public class InstitutionService {

    @Autowired
    InstitutionRepository institutionRepository;

    public InstitutionResponse getInstitution(String uuid) throws EntityNotFoundException {
        return institutionRepository.getInstitution(uuid);
    }

    public List<InstitutionResponse> listInstitutions() {
        return institutionRepository.listInstitutions();
    }

    public InstitutionResponse createInstitution(InstitutionRequest request) throws EntityNotFoundException, ExistingCNPJException, MalformedEntityException, ExistingUserException {
        validateFields(request);
        return institutionRepository.createInstitution(request);
    }

    public void patchInstitution(InstitutionPatchRequest request, String uuid) throws EntityNotFoundException, MalformedEntityException {
        validateFields(request);
        institutionRepository.patchInstitution(request, uuid);
    }

    public Institution findByUser(int id) {
        return institutionRepository.findByUser(id);
    }

    public List<InstitutionResponse> listPendingInstitutions() {
        return institutionRepository.listPendingInstitutions();
    }

    public void editStatus(InstitutionEditStatusRequest editStatusRequest) throws EntityNotFoundException, MalformedEntityException {
        validateFields(editStatusRequest);
        institutionRepository.editStatusRequest(editStatusRequest);
    }

    public Institution getPureInstitution(int id) throws EntityNotFoundException {
        return institutionRepository.getPureInstitution(id);
    }
}
