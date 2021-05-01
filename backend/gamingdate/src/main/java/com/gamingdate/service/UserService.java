package com.gamingdate.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.gamingdate.model.ModelUser;
import com.gamingdate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepository repository;
    @Override
    public List<ModelUser> findAll() {
        var Users = (List<ModelUser>) repository.findAll();
        return Users;
    }
    @Override
    public ModelUser findById(Long id){
        var User = (ModelUser) repository.findById(id).orElseThrow(NoSuchElementException::new);
        return User;
    }
    @Override
    public boolean addOne(ModelUser newModelUser) {
        repository.save(newModelUser);
        return true;
    }
    @Override
    public boolean updateOne(ModelUser updatedModelUser) {
        repository.save(updatedModelUser);
        return true;
    }
    
    @Override
    public boolean deleteById(Long id) {
        var User = (ModelUser) repository.findById(id).orElseThrow(NoSuchElementException::new);
        repository.delete(User);
        return true;
    }
}