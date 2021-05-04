package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.Profile;
import com.gamingdate.repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService implements IProfileService{
    @Autowired
    private ProfileRepository repository;
    @Override
    public List<Profile> findAll() {
        var Profiles = (List<Profile>) repository.findAll();
        return Profiles;
    }
    @Override
    public Profile findById(Long id){
        var Profile = (Profile) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return Profile;
    }
    @Override
    public boolean addOne(Profile newModelProfile) {
        repository.save(newModelProfile);
        return true;
    }
    @Override
    public boolean updateOne(Profile updatedModelProfile) {
        repository.save(updatedModelProfile);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var Profile = (Profile) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(Profile);
        return true;
    }
}