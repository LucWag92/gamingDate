package com.gamingdate.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
@Entity
@Table(name="accountdata")
@Data
public class AccountData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    Long accountdataid;
    @NonNull String email;
    @NonNull String hashedpassword;  
    public AccountData(){
        super();
     }
}
