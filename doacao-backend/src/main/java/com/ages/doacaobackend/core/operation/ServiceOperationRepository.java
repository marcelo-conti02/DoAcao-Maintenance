package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface ServiceOperationRepository extends JpaRepository<Service, Integer>{

    @Query("SELECT i FROM Service i WHERE i.name = :name")
    Optional<Service> findByName(@Param("name") String name);
    
}
