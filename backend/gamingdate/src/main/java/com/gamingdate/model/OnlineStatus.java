package com.gamingdate.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;


@Entity
@Table(name="onlinestatus")
@Data
public class OnlineStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="onlinestatusid")
    private Long onlineStatusId;

    @Column(name="status")
    @NotBlank(message = "status is mandatory")
    private String status;

    // @OneToOne(mappedBy = "onlineStatus")
    // @NotNull
    // private Profile profile;

    // default connstructor which is only used for JPA
    protected OnlineStatus(){}
    public OnlineStatus(String status){
        this.status = status;
    }
}
