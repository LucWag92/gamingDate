package com.gamingdate.classes;

import lombok.Data;
import lombok.NonNull;

@Data
public class Profile {
    @NonNull String profileId;
    @NonNull String onlineStatusId;
    @NonNull String profileName;
    String profileImageURL;
    String gameDateId;
    String friendListId;
}
