package com.gamingdate.classes;

import lombok.Data;
import lombok.NonNull;

@Data
public class AccountData {
    @NonNull Long accountDataId;
    String eMail;
    String hashedPassword;
}
