package com.gamingdate.classes;

import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class Profile {
    @NonNull Long profileId;
    @NonNull OnlineStatus onlineStatus;
    @NonNull String profileName;
    String profileImageURL;
    @NonNull List<Game> games;
    @NonNull List<Profile> friendProfiles;
}
