package com.yh.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Order(1)
public class DataSourceProperties {

	@ConfigurationProperties(prefix = "spring.datasource.masterdata")
	@Configuration("masterdataDataSourceProperties")
	public static class MasterdataDataSourceProperties extends AbstractDataSourceProperties {
		
	}
	
	@lombok.Data
	private static abstract class AbstractDataSourceProperties {
		protected String driver;
		protected String url;
		protected String username;
		protected String password;
		protected int minIdle;
		protected int maxActive;
		protected int initialSize;
		protected long timeBetweenEvictionRunsMillis;
		protected long minEvictableIdleTimeMillis;
		protected String validationQuery;
		protected boolean testWhileIdle;
		protected boolean testOnBorrow;
		protected boolean testOnReturn;
	}

}
