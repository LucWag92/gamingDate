package com.gamingdate.classes;

import lombok.Data;
import lombok.NonNull;

@Data
public class GameDate2GamesMapping {
    @NonNull String gameDateId;
    @NonNull String gameID;
}
