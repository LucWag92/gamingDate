package com.gamingdate.repository;

import com.gamingdate.model.Clan;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClanRepository extends CrudRepository<Clan, Long>{
    
}
