package com.gamingdate.classes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;


class UserTest {
    AccountData accountData = new AccountData(1L, "mail", "pw");
    OnlineStatus onlineStatus = new OnlineStatus(1L, "status");
    List<Game> games = new ArrayList<Game>();
    List<Profile> friendProfiles = new ArrayList<Profile>();
    Profile profile = new Profile(1L, onlineStatus, "profileName", games, friendProfiles);
    User user = new User(1L, accountData, profile);

    @Test
    void getUserId() {
        assertThat(user.getUserId()).isEqualTo(1L);
    }

    @Test
    void getAccountData() {
        assertThat(user.getAccountData()).isEqualTo(accountData);
    }

    @Test
    void getProfile() {
        assertThat(user.getProfile()).isEqualTo(profile);
    }

    @Test
    void setUserId() {
        user.setUserId(2L);
        assertThat(user.getUserId()).isEqualTo(2L);
    }

    @Test
    void setAccountData() {
        AccountData accountData2 = new AccountData(2L, "mail2", "pw2");
        user.setAccountData(accountData2);
        assertThat(user.getAccountData()).isEqualTo(accountData2);
    }

    @Test
    void setProfile() {
        Profile profile2 = new Profile(2L, onlineStatus, "profileName", games, friendProfiles);
        user.setProfile(profile2);
        assertThat(user.getProfile()).isEqualTo(profile2);
    }
}