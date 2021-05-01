package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.ModelGame;

public interface IGameService {
    List<ModelGame> findAll();
    ModelGame findById(Long id);
    boolean addOne(ModelGame newModelGame);
    boolean updateOne(ModelGame updatedModelGame);
    boolean deleteById(Long id);
}
