package com.ages.doacaobackend.core.operation;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ages.doacaobackend.business.entity.ServiceSolicitation;

@Transactional
public interface ServiceSolicitationOperationRepository extends JpaRepository<ServiceSolicitation, Integer>{
    
}
