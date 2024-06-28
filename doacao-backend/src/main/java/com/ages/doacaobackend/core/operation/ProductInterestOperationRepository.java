package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.ProductInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductInterestOperationRepository extends JpaRepository<ProductInterest, Integer> {

    @Query("SELECT i FROM ProductInterest i WHERE i.idProductOrderInterest.idProductOrderInterest = :idProductOrderInterest")
    List<ProductInterest> findAllByOrderId(@Param("idProductOrderInterest") int idProductOrderInterest);
}
