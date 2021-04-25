package com.gamingdate.model;
import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull String userId;
    @NonNull String accountDataId;
    @NonNull String profileId;
}

