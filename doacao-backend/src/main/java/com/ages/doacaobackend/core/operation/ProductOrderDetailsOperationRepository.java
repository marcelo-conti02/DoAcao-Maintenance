package com.ages.doacaobackend.core.operation;


import com.ages.doacaobackend.business.entity.ProductDetailsOrder;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductOrderDetailsOperationRepository extends JpaRepository<ProductDetailsOrder,Integer> {

    @Query("SELECT p FROM ProductDetailsOrder p WHERE p.status = 'P' AND p.isUrgent = true ORDER BY p.createdTime ASC")
    List<ProductDetailsOrder> findAllAnalysisUrgentOrders();

    @Modifying
    @Query("UPDATE ProductDetailsOrder p SET p.status = :status WHERE p.idProductDetailsOrder = :orderId AND p.status = 'P' ")
    void updateStatusById(@Param("status") GeneralStatus status, @Param("orderId") int orderId);

    @Query("SELECT p FROM ProductDetailsOrder p WHERE p.idInstitution.city = :city")
    List<ProductDetailsOrder> findAllByInstitutionCity(@Param("city") String city);
}
