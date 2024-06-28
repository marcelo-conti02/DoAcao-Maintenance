package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.ProductOrderInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductOrderInterestOperationRepository extends JpaRepository<ProductOrderInterest, Integer> {

    @Query("SELECT i FROM ProductOrderInterest i WHERE i.idProductDetailsOrder.idProductDetailsOrder = :id")
    List<ProductOrderInterest> findAllByOrderId(@Param("id") int id);

}
