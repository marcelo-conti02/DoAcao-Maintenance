package com.ages.doacaobackend.core.operation;


import com.ages.doacaobackend.business.entity.Item;
import com.ages.doacaobackend.business.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface ItemOperationRepository extends JpaRepository<Item,Integer> {

    @Query("SELECT i FROM Item i WHERE i.name = :name")
    Optional<Item> findByName(@Param("name") String name);

}
