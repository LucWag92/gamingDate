package com.gamingdate.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class OnlineStatus {
    @NonNull String onlineStatusId;
    @NonNull String status;
}
