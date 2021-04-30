package com.gamingdate.controller;


import java.util.List;

import com.gamingdate.model.ModelAccountData;
import com.gamingdate.service.IAccountDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GamingDateController {
    @Autowired
    private IAccountDataService accountDataService;
    @GetMapping("/accountData/all")
    public List<ModelAccountData> findAllAccountData() {
        var accountDatas = (List<ModelAccountData>) accountDataService.findAll();
        return accountDatas;
    }
    @GetMapping("/accountData/{id}")
    public ModelAccountData getAccountData(@PathVariable long id) {
        var accountData = (ModelAccountData) accountDataService.findById(id);
        return accountData;
    }    
}
