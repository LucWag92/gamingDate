package com.gamingdate.model;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountDataTest {
    AccountData aD = new AccountData("0", "mail", "pw");
    @Test
    // Getter
    void getAccountID() {
        assertThat(aD.getAccountDataId()).isEqualTo("0");
    }
    @Test
    void getEMail() {
        assertThat(aD.getEMail()).isEqualTo("mail");
    }
    @Test
    void getPassword() {
        assertThat(aD.getHashedPassword()).isEqualTo("pw");
    }
    // Setter
    @Test
    void setAccounID() {
        aD.setAccountDataId("1");
        assertThat(aD.getAccountDataId()).isEqualTo("1");
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
