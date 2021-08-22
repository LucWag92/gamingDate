package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.Clan;

public interface IClanService {
    List<Clan> findAll();
    Clan findById(Long id);
    boolean addOne(Clan updatedFriendGroup);
    boolean updateOne(Clan updatedFriendGroup);
    boolean deleteById(Long id);
}
