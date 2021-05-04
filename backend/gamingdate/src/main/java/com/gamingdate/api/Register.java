package com.gamingdate.api;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Register {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String profileName;
}
