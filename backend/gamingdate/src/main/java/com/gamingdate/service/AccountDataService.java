package com.gamingdate.service;

import java.util.List;

import com.gamingdate.exceptions.exception.AccountDataNotFoundException;
import com.gamingdate.model.ModelAccountData;
import com.gamingdate.repository.AccountDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDataService implements IAccountDataService{
    @Autowired
    private AccountDataRepository repository;
    @Override
    public List<ModelAccountData> findAll() {
        var accountDatas = (List<ModelAccountData>) repository.findAll();
        return accountDatas;
    }
    @Override
    public ModelAccountData findById(Long id){
        var accountData = (ModelAccountData) repository.findById(id).orElseThrow(AccountDataNotFoundException::new);;
        return accountData;
    }
}
