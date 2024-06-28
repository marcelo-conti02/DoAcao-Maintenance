package com.ages.doacaobackend.core.operation;

import com.ages.doacaobackend.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserOperationRepository  extends JpaRepository<User,Integer>{
    
}
