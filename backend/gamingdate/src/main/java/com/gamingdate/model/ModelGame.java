package com.gamingdate.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name="game")
@Data
public class ModelGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gameid")
    Long gameId;
    @Column(name="gamename")
    @NonNull String gameName;
    @Column(name="gamelogourl")
    String gameLogoURL; 
    @Column(name="starttime")
    @NonNull Timestamp startTime;
    @Column(name="endTime")
    @NonNull Timestamp endtime;
    @Column(name="rating")
    Integer rating; 
    // default connstructor which is only used for JPA
    protected ModelGame(){}
    public ModelGame(String gameName, String gameLogoURL, Timestamp startTime, Timestamp endtime){
        this.gameName = gameName;
        this.gameLogoURL = gameLogoURL;
        this.startTime = startTime;
        this.endtime = endtime;
    }
}
