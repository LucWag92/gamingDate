package com.gamingdate.repository;

import com.gamingdate.model.ModelGame;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<ModelGame, Long>{
    
}
