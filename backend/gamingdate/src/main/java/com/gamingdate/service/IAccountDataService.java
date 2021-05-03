package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.AccountData;

public interface IAccountDataService {
    List<AccountData> findAll();
    AccountData findById(Long id);
    boolean addOne(AccountData newModelAccountData);
    boolean updateOne(AccountData updatedModelAccountData);
    boolean deleteById(Long id);
}
