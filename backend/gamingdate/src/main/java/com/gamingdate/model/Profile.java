package com.gamingdate.model;

import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class Profile {
    @NonNull String profileId;
    @NonNull String onlineStatusId;
    @NonNull String profileName;
    String profileImageURL;
    @NonNull List<Game> gameDates;
    @NonNull List<Profile> friendProfiles;
}
