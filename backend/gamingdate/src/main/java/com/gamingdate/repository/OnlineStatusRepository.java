package com.gamingdate.repository;

import com.gamingdate.model.ModelOnlineStatus;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnlineStatusRepository extends CrudRepository<ModelOnlineStatus, Long>{
    
}
