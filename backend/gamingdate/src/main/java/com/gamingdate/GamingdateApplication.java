package com.gamingdate;

import java.util.Optional;

import com.gamingdate.model.ModelAccountData;
import com.gamingdate.repository.AccountDataRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamingdateApplication {
	private static final Logger log = LoggerFactory.getLogger(GamingdateApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(GamingdateApplication.class, args);
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
