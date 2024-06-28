package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.ServiceInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceInterestOperationRepository extends JpaRepository<ServiceInterest, Integer> {

    @Query("SELECT i FROM ServiceInterest i WHERE i.idServiceOrderInterest.idServiceOrderInterest = :idServiceOrderInterest")
    List<ServiceInterest> findAllByOrderId(@Param("idServiceOrderInterest") int idServiceOrderInterest);
}
