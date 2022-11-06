package com.aky.ccp;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@ActiveProfiles("test")
class CcpBackendApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void contextLoads() throws SQLException {
		Assertions.assertTrue(dataSource instanceof HikariDataSource);
		HikariDataSource hikariDataSource = (HikariDataSource) dataSource;
		Assertions.assertEquals(hikariDataSource.getJdbcUrl(), "jdbc:h2:mem:testccpdb");
	}

}
