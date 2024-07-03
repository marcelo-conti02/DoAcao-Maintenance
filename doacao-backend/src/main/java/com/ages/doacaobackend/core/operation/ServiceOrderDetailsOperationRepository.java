package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.ServiceDetailsOrder;
import com.ages.doacaobackend.business.enums.GeneralStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ServiceOrderDetailsOperationRepository extends JpaRepository<ServiceDetailsOrder, Integer>{

    @Query("SELECT s FROM ServiceDetailsOrder s WHERE s.status = 'P' AND s.isUrgent = true ORDER BY s.createdTime ASC")
    List<ServiceDetailsOrder> findAllAnalysisUrgentOrders();

    @Modifying
    @Query("UPDATE ServiceDetailsOrder s SET s.status = :status WHERE s.idServiceDetailsOrder = :orderId AND s.status = 'P' ")
    void updateStatusById(@Param("status") GeneralStatus status, @Param("orderId") int orderId);
    
    @Query("SELECT p FROM ServiceDetailsOrder p WHERE p.idInstitution.city = :city")
    List<ServiceDetailsOrder> findAllByInstitutionCity(@Param("city") String city);
}
