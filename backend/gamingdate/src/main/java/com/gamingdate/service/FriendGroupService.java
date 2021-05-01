package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.ModelFriendGroup;
import com.gamingdate.repository.FriendGroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendGroupService implements IFriendGroupService{
    @Autowired
    private FriendGroupRepository repository;
    @Override
    public List<ModelFriendGroup> findAll() {
        var FriendGroups = (List<ModelFriendGroup>) repository.findAll();
        return FriendGroups;
    }
    @Override
    public ModelFriendGroup findById(Long id){
        var FriendGroup = (ModelFriendGroup) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return FriendGroup;
    }
    @Override
    public boolean addOne(ModelFriendGroup newModelFriendGroup) {
        repository.save(newModelFriendGroup);
        return true;
    }
    @Override
    public boolean updateOne(ModelFriendGroup updatedModelFriendGroup) {
        repository.save(updatedModelFriendGroup);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var FriendGroup = (ModelFriendGroup) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(FriendGroup);
        return true;
    }
}