package com.gamingdate.controller;

import java.util.List;

import com.gamingdate.model.ModelAccountData;
import com.gamingdate.service.IAccountDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/accountData")
public class AccountDataController {
    @Autowired
    private IAccountDataService accountDataService;
    @GetMapping
    public List<ModelAccountData> finAll() {
        var accountDatas = (List<ModelAccountData>) accountDataService.findAll();
        return accountDatas;
    }
    @GetMapping(path = "{id}")
    public ModelAccountData findById(@PathVariable long id) {
        var accountData = (ModelAccountData) accountDataService.findById(id);
        return accountData;
    }
    @PostMapping
    public boolean addOne(@RequestBody ModelAccountData accountData) {
        return accountDataService.addOne(accountData);
    }
    @PutMapping
    public boolean updateOne(@RequestBody ModelAccountData accountData) {
        return accountDataService.updateOne(accountData);
    }
    @DeleteMapping(path = "{id}")
    public boolean deleteById(@PathVariable long id) {
        return accountDataService.deleteById(id);
    }
}
