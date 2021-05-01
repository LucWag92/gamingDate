package com.gamingdate.classes;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProfileTest {
    OnlineStatus onlineStatus = new OnlineStatus(1L, "status");
    List<Game> games = new ArrayList<Game>();
    List<Profile> friendProfiles = new ArrayList<Profile>();
    Profile profile = new Profile(1L, onlineStatus, "profileName", games, friendProfiles);
    // Getter
    @Test
    void getProfileId() {
        assertThat(profile.getProfileId()).isEqualTo(1L);
    }
    @Test
    void getOnlineStatus() {
        assertThat(profile.getOnlineStatus()).isEqualTo(onlineStatus);
    }
    @Test
    void getProfileName() {
        assertThat(profile.getProfileName()).isEqualTo("profileName");
    }
    @Test
    void getGames() {
        assertThat(profile.getGames()).isEqualTo(games);
    }
    @Test
    void getFriendProfiles() {
        assertThat(profile.getFriendProfiles()).isEqualTo(friendProfiles);
    }
    @Test
    void getProfileImageURL() {
        assertThat(profile.getProfileImageURL()).isNull();
    }

    // Setter
    @Test
    void setProfileId() {
        profile.setProfileId(2L);
        assertThat(profile.getProfileId()).isEqualTo(2L);
    }
    @Test
    void setOnlineStatusId() {
        OnlineStatus oS = new OnlineStatus(1L, "status");
        profile.setOnlineStatus(oS);
        assertThat(profile.getOnlineStatus()).isEqualTo(oS);
    }
    @Test
    void setProfileName() {
        profile.setProfileName("profileName2");
        assertThat(profile.getProfileName()).isEqualTo("profileName2");
    }
    @Test
    void setGameDateIds() {
        Timestamp startTime = Timestamp.valueOf("2021-01-01 10:10:10.0");
        Timestamp endTime = Timestamp.valueOf("2021-01-01 11:10:10.0");
        Game game = new Game(1L, "gameName", startTime, endTime);
        profile.setGames(Arrays.asList(game));
        assertThat(profile.getGames()).isEqualTo(Arrays.asList(game));
    }
    @Test
    void setFriendProfiles() {
        Profile profile = new Profile(1L, onlineStatus, "profileName", games, friendProfiles);
        List<Profile> friendProfiles = new ArrayList<Profile>(Arrays.asList(profile));
        profile.setFriendProfiles(friendProfiles);
        assertThat(profile.getFriendProfiles()).isEqualTo(friendProfiles);
    }
    @Test
    void setProfileImageURL() {
        profile.setProfileImageURL("profileImageURL");
        assertThat(profile.getProfileImageURL()).isEqualTo("profileImageURL");
    }
}
