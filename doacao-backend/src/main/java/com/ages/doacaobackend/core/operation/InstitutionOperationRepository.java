package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface InstitutionOperationRepository extends JpaRepository<Institution,Integer> {
    @Query("SELECT i FROM Institution i WHERE i.id_user.id = :id")
    Institution findByUser(@Param("id") int id);

    @Query("SELECT i FROM Institution i WHERE i.cnpj = :cnpj")
    Optional<Institution> findByCNPJ(@Param("cnpj") String cnpj);

}
