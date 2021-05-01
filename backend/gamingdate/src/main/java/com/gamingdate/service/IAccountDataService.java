package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.ModelAccountData;

public interface IAccountDataService {
    List<ModelAccountData> findAll();
    ModelAccountData findById(Long id);
    boolean addOne(ModelAccountData newModelAccountData);
    boolean updateOne(ModelAccountData updatedModelAccountData);
    boolean deleteById(Long id);
}
