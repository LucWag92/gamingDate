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
@Table(name="accountdata")
@Data
public class ModelAccountData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="accountdataid")
    Long accountDataId;
    @Column(name="email")
    @NonNull String eMail;
    @Column(name="hashedpassword")
    @NonNull String hashedPassword;  
    // default connstructor which is only used for JPA
    protected ModelAccountData(){}
    public ModelAccountData(String eMail, String hashedPassword){
        this.eMail = eMail;
        this.hashedPassword = hashedPassword;
    }
    
}