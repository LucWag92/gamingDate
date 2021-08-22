package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.Profile;

public interface IProfileService {
    List<Profile> findAll();
    Profile findById(Long id);
    boolean addOne(Profile updatedProfile);
    boolean updateOne(Profile updatedProfile);
    boolean deleteById(Long id);
    List<Profile> findByProfileName(String profileName);
    
}
