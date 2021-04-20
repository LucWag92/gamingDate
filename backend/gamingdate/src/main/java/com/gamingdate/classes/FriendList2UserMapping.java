package com.gamingdate.classes;

import lombok.Data;
import lombok.NonNull;

@Data
public class FriendList2UserMapping {
    @NonNull String friendListId;
    @NonNull String profileId;
}
