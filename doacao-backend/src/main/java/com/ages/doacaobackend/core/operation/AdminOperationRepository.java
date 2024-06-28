package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface AdminOperationRepository extends JpaRepository<Administrator, Integer>{
    @Query("SELECT a FROM Administrator a WHERE a.id_user.id = :id")
    Administrator findByUser(@Param("id") int id);
}
