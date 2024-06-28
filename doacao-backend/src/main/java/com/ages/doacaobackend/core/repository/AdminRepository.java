package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.entity.Administrator;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.mappers.AdminMapper;
import com.ages.doacaobackend.core.operation.AdminOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class AdminRepository {

    @Autowired
    AdminOperationRepository operationRepository;

    @Autowired
    AdminMapper mapper;

    public List<AdminDTO> getAll() {
        return operationRepository.findAll().stream().map(mapper::adminToAdminDTO).collect(Collectors.toList());
    }

    public AdminDTO getAdmin(int id_admin)  throws EntityNotFoundException{
       Optional<Administrator> admin = operationRepository.findById(id_admin);

        if(!admin.isPresent()) throw new EntityNotFoundException("Entidade nao encontrada");

       Administrator administrator = admin.get();

       return mapper.adminToAdminDTO(administrator);       
    }

    public AdminDTO getAdminByUser(int idUser) throws EntityNotFoundException {
        return mapper.adminToAdminDTO(operationRepository.findByUser(idUser));
    }
}
