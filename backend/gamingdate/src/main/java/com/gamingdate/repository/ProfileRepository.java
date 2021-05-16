package com.gamingdate.repository;

import java.util.List;

import com.gamingdate.model.Profile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{
    List<Profile> findByProfileName(String profileName);
}
