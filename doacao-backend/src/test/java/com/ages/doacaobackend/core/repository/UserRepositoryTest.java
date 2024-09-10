package com.ages.doacaobackend.core.repository;

import com.ages.doacaobackend.business.dto.Administrator.AdminDTO;
import com.ages.doacaobackend.business.dto.User.LoginRequest;
import com.ages.doacaobackend.business.dto.User.UserResponse;
import com.ages.doacaobackend.business.entity.User;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.core.operation.UserOperationRepository;
import com.ages.doacaobackend.core.service.AdminService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @MockBean
    UserOperationRepository operationRepository;

    @MockBean
    AdminService adminService;

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Should successfully login in admin account")
    void loginAdmin() throws EntityNotFoundException {
        User adminUser = new User().withLogin("loginAdmin").withPassword("passwordAdmin").withIsAdmin(true).withId(2);
        AdminDTO admin = new AdminDTO(1,"admin", "admin@gmail.com");

        when(operationRepository.save(adminUser)).thenReturn(adminUser);
        when(adminService.getAdminByUser(adminUser.getId())).thenReturn(admin);

        Optional<User> savedUser = operationRepository.findById(adminUser.getId());
        assertTrue(savedUser.isPresent(), "O usuário não foi salvo corretamente.");

        LoginRequest request = new LoginRequest().withLogin("loginAdmin").withPassword("passwordAdmin");
        UserResponse response = userRepository.login(request);

        assertEquals(admin.getId_adm(), response.getId_adm());
        assertEquals(admin.getEmail(), response.getEmail());
        assertEquals(admin.getName(), response.getName());
        assertTrue(response.isIsAdmin());
    }

}