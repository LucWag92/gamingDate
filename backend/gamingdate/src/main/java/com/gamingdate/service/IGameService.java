package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.Game;

public interface IGameService {
    List<Game> findAll();
    Game findById(Long id);
    boolean addOne(Game updatedGame);
    boolean updateOne(Game updatedGame);
    boolean deleteById(Long id);
}
