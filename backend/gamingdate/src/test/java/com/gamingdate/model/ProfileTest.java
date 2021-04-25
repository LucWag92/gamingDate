package com.gamingdate.model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

public class ProfileTest {
    Profile profile = new Profile("profileId", "onlineStatusId", "profileName", Arrays.asList("1", "2", "3"), Arrays.asList("1", "2", "3"));
    // Getter
    @Test
    void getProfileId() {
        assertThat(profile.getProfileId()).isEqualTo("profileId");
    }
    @Test
    void getOnlineStatusId() {
        assertThat(profile.getOnlineStatusId()).isEqualTo("onlineStatusId");
    }
    @Test
    void getProfileName() {
        assertThat(profile.getProfileName()).isEqualTo("profileName");
    }
    @Test
    void getGameDateIds() {
        assertThat(profile.getGameDateIds()).isEqualTo(Arrays.asList("1", "2", "3"));
    }
    @Test
    void getFriendProfileIds() {
        assertThat(profile.getFriendProfileIds()).isEqualTo(Arrays.asList("1", "2", "3"));
    }
    @Test
    void getProfileImageURL() {
        assertThat(profile.getProfileImageURL()).isNull();
    }

    // Setter
    @Test
    void setProfileId() {
        profile.setProfileId("profileId2");
        assertThat(profile.getProfileId()).isEqualTo("profileId2");
    }
    @Test
    void setOnlineStatusId() {
        profile.setOnlineStatusId("onlineStatusId2");
        assertThat(profile.getOnlineStatusId()).isEqualTo("onlineStatusId2");
    }
    @Test
    void setProfileName() {
        profile.setProfileName("profileName2");
        assertThat(profile.getProfileName()).isEqualTo("profileName2");
    }
    @Test
    void setGameDateIds() {
        profile.setGameDateIds(Arrays.asList("4", "5", "6"));
        assertThat(profile.getGameDateIds()).isEqualTo(Arrays.asList("4", "5", "6"));
    }
    @Test
    void setFriendProfileIds() {
        profile.setFriendProfileIds(Arrays.asList("4", "5", "6"));
        assertThat(profile.getFriendProfileIds()).isEqualTo(Arrays.asList("4", "5", "6"));
    }
    @Test
    void setProfileImageURL() {
        profile.setProfileImageURL("profileImageURL");
        assertThat(profile.getProfileImageURL()).isEqualTo("profileImageURL");
    }
}
