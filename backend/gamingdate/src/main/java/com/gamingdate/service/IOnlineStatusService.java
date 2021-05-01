package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.ModelOnlineStatus;

public interface IOnlineStatusService {
    List<ModelOnlineStatus> findAll();
    ModelOnlineStatus findById(Long id);
    boolean addOne(ModelOnlineStatus newModelOnlineStatus);
    boolean updateOne(ModelOnlineStatus updatedModelOnlineStatus);
    boolean deleteById(Long id);
}
