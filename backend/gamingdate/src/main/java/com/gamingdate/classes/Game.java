package com.gamingdate.classes;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NonNull;

@Data
public class Game {
    @NonNull Long gameId;
    @NonNull String gameName;
    String gameLogoURL;
    @NonNull Timestamp startTime;
    @NonNull Timestamp endTime;
    Integer rating;
}
