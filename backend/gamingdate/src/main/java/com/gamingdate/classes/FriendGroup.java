package com.gamingdate.classes;

import lombok.Data;
import lombok.NonNull;

@Data
public class FriendGroup {
    @NonNull String friendGroupId;
    String friendGroup2ProfileMappingId;
    @NonNull String friendGroupName;
    String lastFavouriteGame;
}
