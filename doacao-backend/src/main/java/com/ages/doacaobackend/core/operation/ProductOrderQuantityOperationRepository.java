package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.ProductDetailsOrder;
import com.ages.doacaobackend.business.entity.ProductQuantityOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProductOrderQuantityOperationRepository extends JpaRepository<ProductQuantityOrder, Integer> {

    @Query("SELECT p.idProductQuantityOrder FROM ProductQuantityOrder p WHERE p.idProductDetailsOrder = :orderId")
    List<Integer> findAllIdsByOrderId(@Param("orderId") ProductDetailsOrder orderId);

    @Modifying
    @Query("DELETE FROM ProductQuantityOrder p WHERE p.idProductQuantityOrder = :idProductQuantityOrder")
    void deleteById(@Param("idProductQuantityOrder") int idProductQuantityOrder);
}
