package com.mountain.config;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TestDataContextConfiguration {

	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Bean
	public Server dataSourceTcpConnector()
	{
		try {
			return Server.createTcpServer();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
