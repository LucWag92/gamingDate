package com.gamingdate.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="usertable")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="accountdataid", referencedColumnName = "accountdataid")
    @NotNull 
    private AccountData accountData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profileid", referencedColumnName = "profileid")
    @NotNull 
    private Profile profile;

    // default connstructor which is only used for JPA
    protected User(){}
}
