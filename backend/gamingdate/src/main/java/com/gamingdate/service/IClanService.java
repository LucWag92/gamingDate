package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.Clan;

public interface IClanService {
    List<Clan> findAll();
    Clan findById(Long id);
    boolean addOne(Clan newModelFriendGroup);
    boolean updateOne(Clan updatedModelFriendGroup);
    boolean deleteById(Long id);
}
