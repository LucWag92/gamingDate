package com.gamingdate.model;
import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull
    String userId;
    @NonNull
    Integer accountDataId;
    @NonNull
    Integer profileId;
}

