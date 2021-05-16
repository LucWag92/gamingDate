package com.gamingdate.service;

import java.util.List;

import com.gamingdate.model.User;


public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    boolean addOne(User newUser);
    boolean updateOne(User updatedUser);
    boolean deleteById(Long id);
}
