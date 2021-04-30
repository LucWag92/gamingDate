package com.gamingdate.controller;


import java.util.List;

import com.gamingdate.model.AccountData;
import com.gamingdate.service.IAccountDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor //
public class GamingDateController {
    @Autowired
    private IAccountDataService accountDataService;
    @GetMapping("/accountData/all")
    public List<AccountData> findAllAccountData() {
        var accountDatas = (List<AccountData>) accountDataService.findAll();
        return accountDatas;
    }
    @GetMapping("/accountData/{id}")
    public AccountData getAccountData(@PathVariable long id) {
        var accountData = (AccountData) accountDataService.findById(id);
        return accountData;
    }
    
}
