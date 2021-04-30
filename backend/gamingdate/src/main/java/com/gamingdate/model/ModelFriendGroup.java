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
@Table(name="friendgroup")
@Data
public class ModelFriendGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="friendgroupid")
    Long friendGroupId;
    @Column(name="friendgroupname")
    @NonNull String friendGroupName;
    @Column(name="lastfavouritegame")
    String lastFavouriteGame;
    @Column(name="friendprofilemappingid")
    @NonNull Long friendProfileMappingId;
    // default connstructor which is only used for JPA
    protected ModelFriendGroup(){}
    public ModelFriendGroup(String friendGroupName, String lastFavouriteGame, Long friendProfileMappingId){
        this.friendGroupName = friendGroupName;
        this.lastFavouriteGame = lastFavouriteGame;
        this.friendProfileMappingId = friendProfileMappingId;
    }
}
