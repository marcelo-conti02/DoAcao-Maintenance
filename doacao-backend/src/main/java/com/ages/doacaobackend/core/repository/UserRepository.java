package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.dto.User.LoginRequest;
import com.ages.doacaobackend.business.dto.User.UserRequest;
import com.ages.doacaobackend.business.dto.User.UserResponse;
import com.ages.doacaobackend.business.entity.Institution;
import com.ages.doacaobackend.business.entity.User;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.mappers.UserMapper;
import com.ages.doacaobackend.core.operation.UserOperationRepository;
import com.ages.doacaobackend.core.service.AdminService;
import com.ages.doacaobackend.core.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    
    @Autowired
    UserOperationRepository operationRepository;

    @Autowired
    AdminService adminService;

    @Autowired
    InstitutionService institutionService;

    @Autowired
    UserMapper mapper;

    public UserResponse login(LoginRequest request) throws EntityNotFoundException {
        List<User> userList = operationRepository.findAll();
        UserResponse dto = new UserResponse();

        for(User user : userList) {
            if(user.getLogin().equals(request.getLogin()) && user.getPassword().equals(user.getPassword())) {
                if(user.getIsAdmin()) {
                    AdminDTO admin = adminService.getAdminByUser(user.getId());

                    dto.withId_Admin(admin.getId_adm())
                       .withId_User(user.getId())
                       .withIsAdmin(user.getIsAdmin())
                       .withName(admin.getName())
                       .withEmail(admin.getEmail());
                }
                else {
                    Institution institution = institutionService.findByUser(user.getId());

                    dto.withId_User(user.getId())
                       .withId_Institution(institution.getId_institution())
                       .withCnpj(institution.getCnpj())
                       .withName(institution.getName())
                       .withPhone(institution.getPhone())
                       .withWhatsapp(institution.getWhatsapp())
                       .withEmail(institution.getEmail())
                       .withStreet(institution.getStreet())
                       .withCity(institution.getCity())
                       .withState(institution.getState());
                }
            }
        }

        return dto;
    } 
    
    public User createUser(UserRequest user) throws EntityNotFoundException{
        User usuario = new User().withLogin(user.getLogin())
                                .withPassword(user.getPassword())
                                .withIsAdmin(false);

        return operationRepository.save(usuario);              
    }
}
