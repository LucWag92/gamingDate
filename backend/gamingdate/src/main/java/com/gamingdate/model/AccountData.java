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
public class AccountData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="accountdataid")
    Long accountDataId;
    @Column(name="email")
    @NonNull String eMail;
    @Column(name="hashedpassword")
    @NonNull String hashedPassword;  
    public AccountData(){
        super();
     }
}
