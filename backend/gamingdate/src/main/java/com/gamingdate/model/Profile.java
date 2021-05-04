package com.gamingdate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(
    name="profile",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "profile_profilename_unique",
            columnNames = "profileName"
        )
    }
)
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profileid")
    private Long profileId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="onlinestatusid", referencedColumnName = "onlinestatusid")
    @NotNull 
    private OnlineStatus onlineStatus;

    @Column(name="profilename")
    @NotBlank(message = "profileName is mandatory")
    private String profileName;

    @Column(name="profileimageurl")
    private String profileImageURL = null;

    @Column(name="friendprofiles")
    @ManyToMany
    @JoinTable(
        name = "friendprofiles", 
        joinColumns = @JoinColumn(name = "profileid"), 
        inverseJoinColumns = @JoinColumn(name = "friendprofilesid"),
        uniqueConstraints=@UniqueConstraint(columnNames={"friendprofilesid","profileid"})
    )
    @NotNull 
    private List<Profile> friendprofiles = new ArrayList<Profile>();

    @ManyToMany(mappedBy = "memberProfiles")
    @NotNull 
    private List<Clan> clans = new ArrayList<Clan>();

    @ManyToMany(mappedBy = "gamerProfiles")
    @NotNull 
    private List<Game> games = new ArrayList<Game>();

    // default connstructor which is only used for JPA
    protected Profile(){}
    public Profile(String profileName){
        this.profileName = profileName;
    }
}
