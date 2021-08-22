package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.Game;
import com.gamingdate.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService implements IGameService{
    @Autowired
    private GameRepository repository;
    @Override
    public List<Game> findAll() {
        var games = (List<Game>) repository.findAll();
        return games;
    }
    @Override
    public Game findById(Long id){
        var game = (Game) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return game;
    }
    @Override
    public boolean addOne(Game newGame) {
        repository.save(newGame);
        return true;
    }
    @Override
    public boolean updateOne(Game updatedGame) {
        repository.save(updatedGame);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var game = (Game) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(game);
        return true;
    }
}