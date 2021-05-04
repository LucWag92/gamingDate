package com.gamingdate.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import com.gamingdate.api.Register;
import com.gamingdate.exceptions.EMailException;
import com.gamingdate.exceptions.ProfileNameException;
import com.gamingdate.model.AccountData;
import com.gamingdate.model.OnlineStatus;
import com.gamingdate.model.Profile;
import com.gamingdate.model.User;
import com.gamingdate.service.IAccountDataService;
import com.gamingdate.service.IProfileService;
import com.gamingdate.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping("all/api/v1/register")
public class RegisterController {
    @Autowired
    private IProfileService profileService;
    @Autowired
    private IAccountDataService accountDataService;
    @Autowired
    private IUserService userService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping
    @RolesAllowed("all")
    public ResponseEntity<User> register(@Valid @RequestBody Register register) throws EMailException, ProfileNameException {
        // Check EMail
        if (accountDataService.findByeMail(register.getEmail()).size() != 0) {
            throw new EMailException(register.getEmail());
        }
        // Check ProfileName
        if (profileService.findByProfileName(register.getProfileName()).size() != 0) {
            throw new ProfileNameException(register.getProfileName());
        }
        // Constrains verhindern dass doppelt EMail oder 
        User newUser = new User();
        AccountData accountData = new AccountData(register.getEmail(), passwordEncoder.encode(register.getPassword()));
        newUser.setAccountData(accountData);

        Profile profile = new Profile(register.getProfileName());
        OnlineStatus onlineStatus = new OnlineStatus("offline");
        profile.setOnlineStatus(onlineStatus);
        newUser.setProfile(profile);
        userService.addOne(newUser);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newUser);
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

    @ExceptionHandler({EMailException.class, ProfileNameException.class})
    public ResponseEntity<String> handleNoSuchElementFoundException(
        Exception exception
    ) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(exception.getMessage());
    }
}


