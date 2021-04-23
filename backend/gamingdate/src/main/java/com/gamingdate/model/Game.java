package com.gamingdate.model;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NonNull;

@Data
public class Game {
    @NonNull String gameId;
    @NonNull String gameName;
    String gameLogoURL;
    @NonNull Timestamp startTime;
    @NonNull Timestamp endTime;
    @NonNull Integer rating;
}
