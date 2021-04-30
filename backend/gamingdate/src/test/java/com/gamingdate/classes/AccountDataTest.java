package com.gamingdate.classes;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class AccountDataTest {
    AccountData aD = new AccountData(1L);
    
    @Test
    void getAccounDataId() {
        assertThat(aD.getAccountDataId()).isEqualTo(1L);
    }
    @Test
    void getEMail() {
        assertThat(aD.getEMail()).isNull();
    }
    
    @Test
    void getPassword() {
        assertThat(aD.getHashedPassword()).isNull();
    }
    // Setter
    @Test
    void setAccounDataId() {
        aD.setAccountDataId(2L);
        assertThat(aD.getAccountDataId()).isEqualTo(2L);
    }
    @Test
    void setEMail() {
        aD.setEMail("mail2");
        assertThat(aD.getEMail()).isEqualTo("mail2");
    }
    @Test
    void setPassword() {
        aD.setHashedPassword("pw2");
        assertThat(aD.getHashedPassword()).isEqualTo("pw2");
    }
}
