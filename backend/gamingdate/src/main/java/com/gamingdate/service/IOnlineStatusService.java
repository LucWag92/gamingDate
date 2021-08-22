package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.OnlineStatus;

public interface IOnlineStatusService {
    List<OnlineStatus> findAll();
    OnlineStatus findById(Long id);
    boolean addOne(OnlineStatus newOnlineStatus);
    boolean updateOne(OnlineStatus updatedOnlineStatus);
    boolean deleteById(Long id);
}
