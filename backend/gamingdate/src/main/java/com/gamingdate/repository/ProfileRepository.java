package com.gamingdate.repository;

import com.gamingdate.model.ModelProfile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<ModelProfile, Long>{
    
}
