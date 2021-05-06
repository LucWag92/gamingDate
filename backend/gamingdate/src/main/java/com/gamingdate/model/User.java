package com.gamingdate.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Size(min = 4, message = "Minimum password length: 4 characters")
    private String password;

    // default connstructor which is only used for JPA
    public User(){}
}
