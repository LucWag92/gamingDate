package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.AccountData;
import com.gamingdate.repository.AccountDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDataService implements IAccountDataService{
    @Autowired
    private AccountDataRepository repository;
    @Override
    public List<AccountData> findAll() {
        var accountDatas = (List<AccountData>) repository.findAll();
        return accountDatas;
    }
    @Override
    public AccountData findById(Long id){
        var accountData = (AccountData) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return accountData;
    }
    @Override
    public boolean addOne(AccountData newModelAccountData) {
        repository.save(newModelAccountData);
        return true;
    }
    @Override
    public boolean updateOne(AccountData updatedModelAccountData) {
        repository.save(updatedModelAccountData);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var accountData = (AccountData) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(accountData);
        return true;
    }
}