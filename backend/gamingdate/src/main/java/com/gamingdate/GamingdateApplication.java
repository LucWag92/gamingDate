package com.gamingdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GamingdateApplication {
	public static void main(String[] args) {
		SpringApplication.run(GamingdateApplication.class, args);
	}
	
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
      return new BCryptPasswordEncoder();
  }

  // @Bean
  // public CommandLineRunner demo(AccountDataRepository repository) {
  //   return (args) -> {
  //     // save a few customers
  //     repository.save(new ModelAccountData("Mail1", "pw1"));
  //     repository.save(new ModelAccountData("Mail2", "pw2"));
	//   repository.save(new ModelAccountData("Mail3", "pw3"));
	//   repository.save(new ModelAccountData("Mail4", "pw4"));
	//   repository.save(new ModelAccountData("Mail5", "pw5"));

  //     // fetch all accountData
  //     log.info("AccountData found with findAll():");
  //     log.info("-------------------------------");
  //     for (ModelAccountData accountData : repository.findAll()) {
  //       log.info(accountData.toString());
  //     }
  //     log.info("");

  //     // fetch an individual accountData by ID
  //     Optional<ModelAccountData> accountData = repository.findById(1L);
  //     log.info("accountData found with findById(1L):");
  //     log.info("--------------------------------");
  //     log.info(accountData.toString());
  //     log.info("");
  //     log.info("");
  //   };
  // }
}
