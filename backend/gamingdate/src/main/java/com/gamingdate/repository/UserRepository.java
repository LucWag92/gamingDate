package com.gamingdate.repository;

import com.gamingdate.model.ModelUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<ModelUser, Long>{
    
}
