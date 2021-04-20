package com.gamingdate.classes;

import lombok.Data;
import lombok.NonNull;

@Data
public class Profile2FriendGroupMapping {
    @NonNull String  profileID;
    @NonNull String  friendsGroupId;
}
