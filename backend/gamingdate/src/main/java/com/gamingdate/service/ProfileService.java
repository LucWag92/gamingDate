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
        var profiles = (List<Profile>) repository.findAll();
        return profiles;
    }
    @Override
    public Profile findById(Long id){
        var profile = (Profile) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return profile;
    }
    @Override
    public boolean addOne(Profile newProfile) {
        repository.save(newProfile);
        return true;
    }
    @Override
    public boolean updateOne(Profile updatedProfile) {
        repository.save(updatedProfile);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var profile = (Profile) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(profile);
        return true;
    }
    @Override
    public List<Profile> findByProfileName(String profileName) {
        return repository.findByProfileName(profileName);
    }
}