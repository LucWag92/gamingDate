package com.gamingdate.model;

import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class FriendGroup {
    @NonNull String friendGroupId;
    @NonNull List<String> friendProfileIds;
    @NonNull String friendGroupName;
    String lastFavouriteGame;
}
