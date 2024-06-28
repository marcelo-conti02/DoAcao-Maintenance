package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public List<AdminDTO> getAll() {
        return adminRepository.getAll();
    }

    public AdminDTO getAdmin(int adminId) throws EntityNotFoundException {
        return adminRepository.getAdmin(adminId);
    }

    public AdminDTO getAdminByUser(int idUser) throws EntityNotFoundException {
        return adminRepository.getAdminByUser(idUser);
    }
}
