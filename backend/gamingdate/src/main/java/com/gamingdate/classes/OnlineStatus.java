package com.gamingdate.classes;

import lombok.Data;
import lombok.NonNull;

@Data
public class OnlineStatus {
    @NonNull Long onlineStatusId;
    @NonNull String status;
}
