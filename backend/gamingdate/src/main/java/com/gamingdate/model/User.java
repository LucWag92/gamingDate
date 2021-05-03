package com.gamingdate.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="usertable")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="accountdataid", referencedColumnName = "accountdataid")
    private AccountData accountData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profileid", referencedColumnName = "profileid")
    @NonNull 
    private Profile profile;

    // default connstructor which is only used for JPA
    protected User(){}
}
