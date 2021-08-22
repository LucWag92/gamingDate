package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.OnlineStatus;
import com.gamingdate.repository.OnlineStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlineStatusService implements IOnlineStatusService{
    @Autowired
    private OnlineStatusRepository repository;
    @Override
    public List<OnlineStatus> findAll() {
        var onlineStatuss = (List<OnlineStatus>) repository.findAll();
        return onlineStatuss;
    }
    @Override
    public OnlineStatus findById(Long id){
        var onlineStatus = (OnlineStatus) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return onlineStatus;
    }
    @Override
    public boolean addOne(OnlineStatus newOnlineStatus) {
        repository.save(newOnlineStatus);
        return true;
    }
    @Override
    public boolean updateOne(OnlineStatus updatedOnlineStatus) {
        repository.save(updatedOnlineStatus);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var onlineStatus = (OnlineStatus) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(onlineStatus);
        return true;
    }
}