package com.gamingdate.controller;

import java.util.List;

import javax.validation.Valid;

import com.gamingdate.model.AccountData;
import com.gamingdate.service.IAccountDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/accountData")
public class AccountDataController {
    @Autowired
    private IAccountDataService accountDataService;
    @GetMapping
    public List<AccountData> finAll() {
        var accountDatas = (List<AccountData>) accountDataService.findAll();
        return accountDatas;
    }
    @GetMapping(path = "{id}")
    public AccountData findById(@PathVariable long id) {
        var accountData = (AccountData) accountDataService.findById(id);
        return accountData;
    }
    @PostMapping
    public boolean addOne(@Valid @RequestBody AccountData accountData) {
        return accountDataService.addOne(accountData);
    }
    @PutMapping
    public boolean updateOne(@RequestBody AccountData accountData) {
        return accountDataService.updateOne(accountData);
    }
    @DeleteMapping(path = "{id}")
    public boolean deleteById(@PathVariable long id) {
        return accountDataService.deleteById(id);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
    MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
    return errors;
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoSuchElementFoundException(
        NoSuchElementException exception
    ) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
    }
}
