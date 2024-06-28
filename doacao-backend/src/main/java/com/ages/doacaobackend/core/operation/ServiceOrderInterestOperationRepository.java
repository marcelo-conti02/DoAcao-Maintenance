package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.ServiceOrderInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceOrderInterestOperationRepository extends JpaRepository<ServiceOrderInterest, Integer> {

    @Query("SELECT i FROM ServiceOrderInterest i WHERE i.idServiceDetailsOrder.idServiceDetailsOrder = :id")
    List<ServiceOrderInterest> findAllByOrderId(@Param("id") int id);

}
