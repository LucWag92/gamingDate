package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.User;
import com.gamingdate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository repository;
    @Override
    public List<User> findAll() {
        var users = (List<User>) repository.findAll();
        return users;
    }
    @Override
    public User findById(Long id){
        var user = (User) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return user;
    }
    @Override
    public boolean addOne(User newUser) {
        repository.save(newUser);
        return true;
    }
    @Override
    public boolean updateOne(User updatedUser) {
        repository.save(updatedUser);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var user = (User) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(user);
        return true;
    }
}