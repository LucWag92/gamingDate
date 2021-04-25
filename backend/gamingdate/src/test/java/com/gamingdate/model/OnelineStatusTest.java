package com.gamingdate.model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class OnelineStatusTest {
    OnlineStatus oS = new OnlineStatus("0", "0");
    // Getter
    @Test
    void getOnlineStatusId() {
        assertThat(oS.getOnlineStatusId()).isEqualTo("0");
    }
    @Test
    void getStatus() {
        assertThat(oS.getStatus()).isEqualTo("0");
    }
    // Setter
    @Test
    void setOnlineStatusId() {
        oS.setOnlineStatusId("1");
        assertThat(oS.getOnlineStatusId()).isEqualTo("1");
    }
    @Test
    void setStatus() {
        oS.setStatus("1");
        assertThat(oS.getStatus()).isEqualTo("1");
    }
}
