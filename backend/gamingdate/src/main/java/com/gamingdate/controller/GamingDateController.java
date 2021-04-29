package com.gamingdate.controller;


import java.util.List;

import com.gamingdate.model.AccountData;
import com.gamingdate.service.IAccountDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GamingDateController {
    @Autowired
    private IAccountDataService accountDataService;
    @GetMapping("/allAccountData")
    public String findAccountData(Model model) {
        var accountDatas = (List<AccountData>) accountDataService.findAll();
        model.addAttribute("accountDatas", accountDatas);
        return "allAccountData";
    }
    
}
