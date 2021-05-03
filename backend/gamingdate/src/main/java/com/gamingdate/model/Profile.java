package com.gamingdate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NonNull;

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
    Long profileId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="onlinestatusid", referencedColumnName = "onlinestatusid")
    @NonNull OnlineStatus onlineStatus;

    @Column(name="profilename")
    @NotBlank(message = "profileName is mandatory")
    private String profileName;

    @Column(name="profileimageurl")
    private String profileImageURL;

    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="friendid")
	private Profile friend;

    @OneToMany(mappedBy = "friend")
    @NonNull 
    private List<Profile> friendprofiles = new ArrayList<Profile>();

    @ManyToMany(mappedBy = "memberProfiles")
    @NonNull List<Clan> clans = new ArrayList<Clan>();

    @ManyToMany(mappedBy = "gamerProfiles")
    @NonNull List<Game> games;

    @OneToOne(mappedBy = "profile")
    private User user;

    // default connstructor which is only used for JPA
    protected Profile(){}
    public Profile(String profileName){
        this.profileName = profileName;
    }
}
