package com.gamingdate.controller;

import java.util.List;

import javax.validation.Valid;

import com.gamingdate.model.OnlineStatus;
import com.gamingdate.service.IOnlineStatusService;

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
@RequestMapping("api/v1/onlineStatus")
public class OnlineStatusController {
    @Autowired
    private IOnlineStatusService OnlineStatusService;
    @GetMapping
    public List<OnlineStatus> finAll() {
        var onlineStatuss = (List<OnlineStatus>) OnlineStatusService.findAll();
        return onlineStatuss;
    }
    @GetMapping(path = "{id}")
    public OnlineStatus findById(@PathVariable long id) {
        var onlineStatus = (OnlineStatus) OnlineStatusService.findById(id);
        return onlineStatus;
    }
    @PostMapping
    public boolean addOne(@Valid @RequestBody OnlineStatus onlineStatus) {
        return OnlineStatusService.addOne(onlineStatus);
    }
    @PutMapping
    public boolean updateOne(@RequestBody OnlineStatus onlineStatus) {
        return OnlineStatusService.updateOne(onlineStatus);
    }
    @DeleteMapping(path = "{id}")
    public boolean deleteById(@PathVariable long id) {
        return OnlineStatusService.deleteById(id);
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
