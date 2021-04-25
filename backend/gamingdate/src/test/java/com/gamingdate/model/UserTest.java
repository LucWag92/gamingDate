package com.gamingdate.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    User user = new User("0", 0, 0);

    @Test
    void getUserId() {
        assertThat(user.getUserId()).isEqualTo("0");
    }

    @Test
    void getAccountDataId() {
        assertThat(user.getAccountDataId()).isEqualTo(0);
    }

    @Test
    void getProfileId() {
        assertThat(user.getProfileId()).isEqualTo(0);
    }

    @Test
    void setUserId() {
        user.setUserId("1");
        assertThat(user.getUserId()).isEqualTo("1");
    }

    @Test
    void setAccountDataId() {
        user.setAccountDataId(1);
        assertThat(user.getAccountDataId()).isEqualTo(1);
    }

    @Test
    void setProfileId() {
        user.setProfileId(1);
        assertThat(user.getProfileId()).isEqualTo(1);
    }
}