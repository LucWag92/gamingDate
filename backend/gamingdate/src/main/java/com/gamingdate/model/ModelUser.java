package com.gamingdate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="user")
@Data
public class ModelUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;
    @Column(name="accountdatamappingid")
    @NonNull Long accountDataMappingId;
    @Column(name="profilemappingid")
    @NonNull Long profileMappingId;
    // default connstructor which is only used for JPA
    protected ModelUser(){}
    public ModelUser(Long accountDataMappingId,Long profileMappingId){
        this.accountDataMappingId = accountDataMappingId;
        this.profileMappingId = profileMappingId;
    }
}
