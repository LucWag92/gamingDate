package com.gamingdate.model;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FriendGroupTest {
    FriendGroup fG = new FriendGroup("0", Arrays.asList("1", "2", "3"), "friendGroupName");
    // Getter
    @Test
    void getFriendGroupId() {
        assertThat(fG.getFriendGroupId()).isEqualTo("0");
    }
    @Test
    void getfriendProfileIds() {
        assertThat(fG.getFriendProfileIds()).isEqualTo(Arrays.asList("1", "2", "3"));
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
        fG.setFriendGroupId("1");
        assertThat(fG.getFriendGroupId()).isEqualTo("1");
    }
    @Test
    void setfriendProfileIds() {
        fG.setFriendProfileIds(Arrays.asList("4", "5", "6"));
        assertThat(fG.getFriendProfileIds()).isEqualTo(Arrays.asList("4", "5", "6"));
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
