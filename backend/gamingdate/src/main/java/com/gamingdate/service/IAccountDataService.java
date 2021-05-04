package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.AccountData;

public interface IAccountDataService {
    List<AccountData> findAll();
    AccountData findById(Long id);
    boolean addOne(AccountData updatedAccountData);
    boolean updateOne(AccountData updatedAccountData);
    boolean deleteById(Long id);
    List<AccountData> findByeMail(String email);
}
