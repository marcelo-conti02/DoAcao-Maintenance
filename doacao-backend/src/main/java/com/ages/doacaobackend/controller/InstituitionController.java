package com.ages.doacaobackend.controller;

import com.ages.doacaobackend.business.dto.Institution.InstitutionEditStatusRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionPatchRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionRequest;
import com.ages.doacaobackend.business.dto.Institution.InstitutionResponse;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.ExistingCNPJException;
import com.ages.doacaobackend.business.exception.ExistingUserException;
import com.ages.doacaobackend.business.exception.MalformedEntityException;
import com.ages.doacaobackend.core.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/institution")
public class InstituitionController {

    @Autowired
    InstitutionService institutionService;

    @GetMapping
    public ResponseEntity<List<InstitutionResponse>> listInstitutions() {
        return ok(institutionService.listInstitutions());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<InstitutionResponse> getInstitution(@PathVariable final String uuid)
            throws EntityNotFoundException {
        return ok(institutionService.getInstitution(uuid));
    }

    @PostMapping
    public ResponseEntity<InstitutionResponse> createInstitution(@RequestBody InstitutionRequest request) throws EntityNotFoundException, ExistingCNPJException, MalformedEntityException, ExistingUserException {
        return new ResponseEntity<InstitutionResponse>(institutionService.createInstitution(request),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{uuid}")
    public ResponseEntity<?> patchInstitution(@PathVariable final String uuid,
            @RequestBody InstitutionPatchRequest request) throws EntityNotFoundException, MalformedEntityException {
        institutionService.patchInstitution(request, uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pendingInstitutions")
    public ResponseEntity<List<InstitutionResponse>> listPendingInstitutions() {
        return ok(institutionService.listPendingInstitutions());
    }

    @PostMapping("/solicitation")
    public ResponseEntity<?> institutionSolicitation(
            @RequestBody InstitutionEditStatusRequest editStatusRequest) throws EntityNotFoundException, MalformedEntityException {
        institutionService.editStatus(editStatusRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
