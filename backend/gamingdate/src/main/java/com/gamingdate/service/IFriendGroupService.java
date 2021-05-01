package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.ModelFriendGroup;

public interface IFriendGroupService {
    List<ModelFriendGroup> findAll();
    ModelFriendGroup findById(Long id);
    boolean addOne(ModelFriendGroup newModelFriendGroup);
    boolean updateOne(ModelFriendGroup updatedModelFriendGroup);
    boolean deleteById(Long id);
}
