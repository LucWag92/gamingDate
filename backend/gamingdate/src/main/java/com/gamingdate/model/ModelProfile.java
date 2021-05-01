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
@Table(name="profile")
@Data
public class ModelProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="profileid")
    Long profileId;
    @Column(name="onlinestatusmappingid")
    @NonNull Long onlineStatusMappingId;
    @Column(name="profilename")
    @NonNull String profileName;
    @Column(name="profileimageurl")
    @NonNull String profileImageURL;
    @Column(name="gamesmappingid")
    @NonNull Long gamesMappingId;
    @Column(name="friendprofilemappingid")
    @NonNull Long friendProfileMappingId;
    // default connstructor which is only used for JPA
    protected ModelProfile(){}
    public ModelProfile(Long onlineStatusMappingId, String profileName, Long gamesMappingId, Long friendProfileMappingId){
        this.onlineStatusMappingId = onlineStatusMappingId;
        this.profileName = profileName;
        this.gamesMappingId = gamesMappingId;
        this.friendProfileMappingId = friendProfileMappingId;
    }
}
