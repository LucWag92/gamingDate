package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.ModelGame;
import com.gamingdate.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService implements IGameService{
    @Autowired
    private GameRepository repository;
    @Override
    public List<ModelGame> findAll() {
        var Games = (List<ModelGame>) repository.findAll();
        return Games;
    }
    @Override
    public ModelGame findById(Long id){
        var Game = (ModelGame) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return Game;
    }
    @Override
    public boolean addOne(ModelGame newModelGame) {
        repository.save(newModelGame);
        return true;
    }
    @Override
    public boolean updateOne(ModelGame updatedModelGame) {
        repository.save(updatedModelGame);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var Game = (ModelGame) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(Game);
        return true;
    }
}