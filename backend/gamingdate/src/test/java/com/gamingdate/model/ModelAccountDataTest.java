// package com.gamingdate.model;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// import static org.assertj.core.api.Assertions.assertThat;

// import java.util.List;
// import com.gamingdate.repository.AccountDataRepository;


// @DataJpaTest
// @AutoConfigureTestDatabase(replace=Replace.NONE)
// public class ModelAccountDataTest {
//     @Autowired
//     private TestEntityManager entityManager;
//     @Autowired
//     private AccountDataRepository repository;
    
//     @Test
//     // Getter
//     void testGetAllAccountData() {
//         AccountData accountData = new AccountData("mail", "pw");
//         entityManager.persist(accountData);
//         List<AccountData> accountDatas= (List<AccountData>)repository.findAll();
//         assertThat(accountDatas.get(0)).isEqualTo(accountData);
//     }
// }
