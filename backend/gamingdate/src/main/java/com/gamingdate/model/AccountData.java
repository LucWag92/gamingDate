package com.gamingdate.model;
import lombok.Data;
import lombok.NonNull;

@Data
public class AccountData {
    @NonNull String accountDataId;
    @NonNull String eMail;
    @NonNull String hashedPassword;  
}
