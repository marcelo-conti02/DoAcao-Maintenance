package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.ServiceDetailsOrder;
import com.ages.doacaobackend.business.entity.ServiceQuantityOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ServiceOrderQuantityOperationRepository extends JpaRepository<ServiceQuantityOrder, Integer> {

    @Query("SELECT s.idServiceQuantityOrder FROM ServiceQuantityOrder s WHERE s.idServiceDetailsOrder = :orderId")
    List<Integer> findAllIdsByOrderId(@Param("orderId") ServiceDetailsOrder orderId);

    @Modifying
    @Query("DELETE FROM ServiceQuantityOrder s WHERE s.idServiceQuantityOrder = :idServiceQuantityOrder")
    void deleteById(@Param("idServiceQuantityOrder") int idServiceQuantityOrder);
}
