package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.ModelProfile;

public interface IProfileService {
    List<ModelProfile> findAll();
    ModelProfile findById(Long id);
    boolean addOne(ModelProfile newModelProfile);
    boolean updateOne(ModelProfile updatedModelProfile);
    boolean deleteById(Long id);
}
