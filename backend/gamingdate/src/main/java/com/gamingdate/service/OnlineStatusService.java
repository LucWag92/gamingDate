package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.ModelOnlineStatus;
import com.gamingdate.repository.OnlineStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlineStatusService implements IOnlineStatusService{
    @Autowired
    private OnlineStatusRepository repository;
    @Override
    public List<ModelOnlineStatus> findAll() {
        var OnlineStatuss = (List<ModelOnlineStatus>) repository.findAll();
        return OnlineStatuss;
    }
    @Override
    public ModelOnlineStatus findById(Long id){
        var OnlineStatus = (ModelOnlineStatus) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return OnlineStatus;
    }
    @Override
    public boolean addOne(ModelOnlineStatus newModelOnlineStatus) {
        repository.save(newModelOnlineStatus);
        return true;
    }
    @Override
    public boolean updateOne(ModelOnlineStatus updatedModelOnlineStatus) {
        repository.save(updatedModelOnlineStatus);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var OnlineStatus = (ModelOnlineStatus) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(OnlineStatus);
        return true;
    }
}