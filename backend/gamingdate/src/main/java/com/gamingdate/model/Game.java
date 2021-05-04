package com.gamingdate.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(
    name="game",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "game_gamename_unique",
            columnNames = "gameName"
        )
    }
)
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gameid")
    private Long gameId;

    @Column(name="gamename")
    @NotBlank(message = "gameName is mandatory")
    private String gameName;

    @Column(name="gamelogourl")
    private String gameLogoURL; 

    @Column(name="starttime")
    @NotNull 
    private Timestamp startTime;

    @Column(name="endTime")
    @NotNull
    private Timestamp endtime;

    @Column(name="rating")
    private Integer rating; 

    @Column(name="gamerprofiles")
    @ManyToMany
    @JoinTable(
        name = "gamerprofiles", 
        joinColumns = @JoinColumn(name = "gameid"), 
        inverseJoinColumns = @JoinColumn(name = "profileid"),
        uniqueConstraints=@UniqueConstraint(columnNames={"gameid","profileid"})
    )
    @NotNull
    private List<Profile> gamerProfiles;

    // default connstructor which is only used for JPA
    protected Game(){}
    public Game(String gameName, Timestamp startTime, Timestamp endtime){
        this.gameName = gameName;
        this.startTime = startTime;
        this.endtime = endtime;
    }
}
