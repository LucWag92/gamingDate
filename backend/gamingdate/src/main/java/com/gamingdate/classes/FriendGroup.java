package com.gamingdate.classes;

import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class FriendGroup {
    @NonNull Long friendGroupId;
    @NonNull List<Profile> friendProfiles;
    @NonNull String friendGroupName;
    String lastFavouriteGame;
}
