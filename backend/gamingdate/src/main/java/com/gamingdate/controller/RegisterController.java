package com.gamingdate.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.gamingdate.api.Register;
import com.gamingdate.exceptions.EMailException;
import com.gamingdate.exceptions.ProfileNameException;
import com.gamingdate.model.AccountData;
import com.gamingdate.model.OnlineStatus;
import com.gamingdate.model.Profile;
import com.gamingdate.model.User;
import com.gamingdate.repository.UserRepository;
import com.gamingdate.service.IAccountDataService;
import com.gamingdate.service.IProfileService;
import com.gamingdate.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/v1/register")
public class RegisterController {
    private UserRepository repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegisterController(UserRepository repository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }



    @PostMapping
    // public void register(@Valid @RequestBody Register register) throws EMailException, ProfileNameException {
    public void register(@RequestBody User user) throws EMailException, ProfileNameException {
        // // Check EMail
        // if (accountDataService.findByeMail(register.getEmail()).size() != 0) {
        //     throw new EMailException(register.getEmail());
        // }
        // // Check ProfileName
        // if (profileService.findByProfileName(register.getUsername()).size() != 0) {
        //     throw new ProfileNameException(register.getUsername());
        // }
        // // Constrains verhindern dass doppelt EMail oder 
        // User newUser = new User();
        // AccountData accountData = new AccountData(register.getEmail(), bCryptPasswordEncoder.encode(register.getPassword()));
        // newUser.setAccountData(accountData);
        // newUser.setEmail(register.getEmail());
        // newUser.setPassword(bCryptPasswordEncoder.encode(register.getPassword()));
        // newUser.setUsername(register.getUsername());

        // Profile profile = new Profile(register.getUsername());
        // OnlineStatus onlineStatus = new OnlineStatus("offline");
        // profile.setOnlineStatus(onlineStatus);
        // newUser.setProfile(profile);
        String pw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setAccountData(new AccountData(user.getEmail(), pw));
        Profile profile = new Profile(user.getUsername());
        OnlineStatus onlineStatus = new OnlineStatus("offline");
        profile.setOnlineStatus(onlineStatus);
        user.setProfile(profile);
        user.setPassword(pw);
        repository.save(user);
        // return ResponseEntity
        //     .status(HttpStatus.CREATED)
        //     .body(newUser);
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


