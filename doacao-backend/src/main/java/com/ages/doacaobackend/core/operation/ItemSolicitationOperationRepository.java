package com.ages.doacaobackend.core.operation;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ages.doacaobackend.business.entity.ItemSolicitation;

@Transactional
public interface ItemSolicitationOperationRepository extends JpaRepository<ItemSolicitation, Integer> {
    
}
