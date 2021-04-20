package com.gamingdate.classes;
import lombok.Data;
import lombok.NonNull;

@Data
public class AccountData {
    @NonNull
    String accountDataId;
    String eMail;
    int hashedPassword;  
}
