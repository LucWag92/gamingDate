package com.gamingdate.classes;
import lombok.Data;
import lombok.NonNull;

@Data
public class User {
    @NonNull Long userId;
    @NonNull AccountData accountData;
    @NonNull Profile profile;
}

