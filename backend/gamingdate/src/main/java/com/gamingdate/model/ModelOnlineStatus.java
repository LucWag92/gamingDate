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
@Table(name="onlinestatus")
@Data
public class ModelOnlineStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="onlinestatusid")
    Long onlineStatusId;
    @Column(name="status")
    @NonNull String status;
    // default connstructor which is only used for JPA
    protected ModelOnlineStatus(){}
    public ModelOnlineStatus(String status){
        this.status = status;
    }
}
