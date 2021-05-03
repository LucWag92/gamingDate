package com.gamingdate.controller;

import java.util.List;

import javax.validation.Valid;

import com.gamingdate.model.Clan;
import com.gamingdate.service.IClanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/friendGroup")
public class FriendGroupController {
    @Autowired
    private IClanService ClanService;
    @GetMapping
    public List<Clan> finAll() {
        var FriendGroups = (List<Clan>) ClanService.findAll();
        return FriendGroups;
    }
    @GetMapping(path = "{id}")
    public Clan findById(@PathVariable long id) {
        var FriendGroup = (Clan) ClanService.findById(id);
        return FriendGroup;
    }
    @PostMapping
    public boolean addOne(@Valid @RequestBody Clan FriendGroup) {
        return ClanService.addOne(FriendGroup);
    }
    @PutMapping
    public boolean updateOne(@RequestBody Clan FriendGroup) {
        return ClanService.updateOne(FriendGroup);
    }
    @DeleteMapping(path = "{id}")
    public boolean deleteById(@PathVariable long id) {
        return ClanService.deleteById(id);
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
