package com.gamingdate.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FriendGroupTest {
    List<Profile> friendProfiles = new ArrayList<Profile>();
    FriendGroup fG = new FriendGroup(1L, friendProfiles, "friendGroupName");
    // Getter
    @Test
    void getFriendGroupId() {
        assertThat(fG.getFriendGroupId()).isEqualTo(1L);
    }
    @Test
    void getfriendProfiles() {
        assertThat(fG.getFriendProfiles()).isEqualTo(friendProfiles);
    }
    @Test
    void getFriendGroupName() {
        assertThat(fG.getFriendGroupName()).isEqualTo("friendGroupName");
    }
    @Test
    void getLastFavouriteGame() {
        assertThat(fG.getLastFavouriteGame()).isNull();
    }
    // Setter
    @Test
    void setFriendGroupId() {
        fG.setFriendGroupId(2L);
        assertThat(fG.getFriendGroupId()).isEqualTo(2L);
    }
    @Test
    void setFriendProfiles() {
        OnlineStatus onlineStatus = new OnlineStatus(1L, "status");
        List<Game> games = new ArrayList<Game>();
        List<Profile> friendProfiles = new ArrayList<Profile>();
        Profile profile = new Profile(1L, onlineStatus, "profileName", games, friendProfiles);
        fG.setFriendProfiles(Arrays.asList(profile));
        assertThat(fG.getFriendProfiles()).isEqualTo(Arrays.asList(profile));
    }
    @Test
    void setFriendGroupName() {
        fG.setFriendGroupName("friendGroupName2");
        assertThat(fG.getFriendGroupName()).isEqualTo("friendGroupName2");
    }
    @Test
    void setLastFavouriteGame() {
        fG.setLastFavouriteGame("lastFavouriteGame");
        assertThat(fG.getLastFavouriteGame()).isEqualTo("lastFavouriteGame");
    }
    
}
