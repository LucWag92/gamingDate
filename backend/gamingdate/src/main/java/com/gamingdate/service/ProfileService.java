package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.ModelProfile;
import com.gamingdate.repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService implements IProfileService{
    @Autowired
    private ProfileRepository repository;
    @Override
    public List<ModelProfile> findAll() {
        var Profiles = (List<ModelProfile>) repository.findAll();
        return Profiles;
    }
    @Override
    public ModelProfile findById(Long id){
        var Profile = (ModelProfile) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return Profile;
    }
    @Override
    public boolean addOne(ModelProfile newModelProfile) {
        repository.save(newModelProfile);
        return true;
    }
    @Override
    public boolean updateOne(ModelProfile updatedModelProfile) {
        repository.save(updatedModelProfile);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var Profile = (ModelProfile) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(Profile);
        return true;
    }
}