package com.gamingdate.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(
    name="clan",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "clan_clanname_unique",
            columnNames = "clanName"
        )
    }
)
@Data
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="clanid")
    Long clanId;

    @Column(name="clanname")
    @NotBlank(message = "clanName is mandatory")
    private String clanName;

    @Column(name="lastfavouritegame")
    private String lastFavouriteGame;


    @Column(name="memberprofiles")
    @ManyToMany
    @JoinTable(
        name = "memberprofiles", 
        joinColumns = @JoinColumn(name = "profileid"), 
        inverseJoinColumns = @JoinColumn(name = "clanid"),
        uniqueConstraints=@UniqueConstraint(columnNames={"clanid","profileid"})
    )
    @NotNull
    private List<Profile> memberProfiles;

    // default connstructor which is only used for JPA
    protected Clan(){}
    public Clan(String clanName){
        this.clanName = clanName;
    }
}
