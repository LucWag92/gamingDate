package com.gamingdate.service;

import java.util.List;

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
}
