package com.aky.ccp;

import com.aky.ccp.entity.CreditCardModal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CcpBackendApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(CcpBackendApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		jdbcTemplate.execute(CreditCardModal.CreditCardQuery.CREATE_CREDIT_CARD_TABLE);
	}
}
