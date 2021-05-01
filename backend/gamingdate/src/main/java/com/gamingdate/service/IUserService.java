package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.ModelUser;

public interface IUserService {
    List<ModelUser> findAll();
    ModelUser findById(Long id);
    boolean addOne(ModelUser newModelUser);
    boolean updateOne(ModelUser updatedModelUser);
    boolean deleteById(Long id);
}
