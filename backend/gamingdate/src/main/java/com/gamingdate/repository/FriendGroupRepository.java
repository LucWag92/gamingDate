package com.gamingdate.repository;

import com.gamingdate.model.ModelFriendGroup;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendGroupRepository extends CrudRepository<ModelFriendGroup, Long>{
    
}
