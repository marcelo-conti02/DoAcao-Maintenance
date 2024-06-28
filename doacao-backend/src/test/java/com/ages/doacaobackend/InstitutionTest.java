package com.ages.doacaobackend;

import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.controller.InstituitionController;
import com.ages.doacaobackend.core.repository.InstitutionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InstituitionController.class)
public class InstitutionTest {    
    
    @Autowired
    MockMvc mockMvc;
    
    @Autowired
    ObjectMapper mapper;
    
    @MockBean
    InstitutionRepository institutionRepository;

    @Test
    @DisplayName("Fail to encounter a institution on GET /{uuid} should return a 404")
    void testNotFound() throws Exception {
        when(institutionRepository.getInstitution("-4")).thenThrow(EntityNotFoundException.class);
    
        mockMvc.perform(MockMvcRequestBuilders
            .get("/institution/-4")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound());
    }
}
