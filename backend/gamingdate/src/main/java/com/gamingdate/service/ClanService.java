package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.Clan;
import com.gamingdate.repository.ClanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanService implements IClanService{
    @Autowired
    private ClanRepository repository;
    @Override
    public List<Clan> findAll() {
        var FriendGroups = (List<Clan>) repository.findAll();
        return FriendGroups;
    }
    @Override
    public Clan findById(Long id){
        var FriendGroup = (Clan) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return FriendGroup;
    }
    @Override
    public boolean addOne(Clan newModelFriendGroup) {
        repository.save(newModelFriendGroup);
        return true;
    }
    @Override
    public boolean updateOne(Clan updatedModelFriendGroup) {
        repository.save(updatedModelFriendGroup);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var FriendGroup = (Clan) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(FriendGroup);
        return true;
    }
}