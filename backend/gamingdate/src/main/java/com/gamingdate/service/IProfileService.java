package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.Profile;

public interface IProfileService {
    List<Profile> findAll();
    Profile findById(Long id);
    boolean addOne(Profile newModelProfile);
    boolean updateOne(Profile updatedModelProfile);
    boolean deleteById(Long id);
}
