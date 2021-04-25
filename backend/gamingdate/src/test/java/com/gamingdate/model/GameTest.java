package com.gamingdate.model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

public class GameTest {
    Timestamp startTime = Timestamp.valueOf("2021-01-01 10:10:10.0");
    Timestamp endTime = Timestamp.valueOf("2021-01-01 11:10:10.0");
    Game game = new Game("0", "gameName", startTime, endTime);

    // Getter
    @Test
    void getGameId() {
        assertThat(game.getGameId()).isEqualTo("0");
    }
    @Test
    void getGameName() {
        assertThat(game.getGameName()).isEqualTo("gameName");
    }
    @Test
    void getStartTime() {
        assertThat(game.getStartTime()).isEqualTo(startTime);
    }
    @Test
    void getEndTime() {
        assertThat(game.getEndTime()).isEqualTo(endTime);
    }
    @Test
    void getGameLogoURL() {
        assertThat(game.getGameLogoURL()).isNull();
    }
    @Test
    void getRating() {
        assertThat(game.getRating()).isNull();
    }
    // Setter
    Timestamp startTime2 = Timestamp.valueOf("2020-01-01 10:10:10.0");
    Timestamp endTime2 = Timestamp.valueOf("2020-01-01 11:10:10.0");
    @Test
    void setGameId() {
        game.setGameId("1");
        assertThat(game.getGameId()).isEqualTo("1");
    }
    @Test
    void setGameName() {
        game.setGameName("gameName2");
        assertThat(game.getGameName()).isEqualTo("gameName2");
    }
    @Test
    void setStartTime() {
        game.setStartTime(startTime2);
        assertThat(game.getStartTime()).isEqualTo(startTime2);
    }
    @Test
    void setEndTime() {
        game.setEndTime(endTime2);
        assertThat(game.getEndTime()).isEqualTo(endTime2);
    }
    @Test
    void setGameLogoURL() {
        game.setGameLogoURL("gameLogoURL");
        assertThat(game.getGameLogoURL()).isEqualTo("gameLogoURL");
    }
    @Test
    void setRating() {
        game.setRating(0);
        assertThat(game.getRating()).isEqualTo(0);
    }
}
