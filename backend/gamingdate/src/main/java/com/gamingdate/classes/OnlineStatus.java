package com.gamingdate.classes;

import lombok.Data;
import lombok.NonNull;

@Data
public class OnlineStatus {
    @NonNull String onlineStatusId;
    @NonNull String status;
}
