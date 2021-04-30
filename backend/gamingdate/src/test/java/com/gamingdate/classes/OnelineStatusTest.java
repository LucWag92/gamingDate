package com.gamingdate.classes;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class OnelineStatusTest {
    OnlineStatus oS = new OnlineStatus(1L, "status");
    // Getter
    @Test
    void getOnlineStatusId() {
        assertThat(oS.getOnlineStatusId()).isEqualTo(1L);
    }
    @Test
    void getStatus() {
        assertThat(oS.getStatus()).isEqualTo("status");
    }
    // Setter
    @Test
    void setOnlineStatusId() {
        oS.setOnlineStatusId(2L);
        assertThat(oS.getOnlineStatusId()).isEqualTo(2L);
    }
    @Test
    void setStatus() {
        oS.setStatus("status1");
        assertThat(oS.getStatus()).isEqualTo("status1");
    }
}
