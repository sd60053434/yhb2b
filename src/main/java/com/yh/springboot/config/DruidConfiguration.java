package com.yh.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

import com.alibaba.druid.pool.DruidDataSource;
import com.yh.springboot.config.DataSourceProperties.MasterdataDataSourceProperties;

@Order(2)
@Configuration
@EnableConfigurationProperties({
	MasterdataDataSourceProperties.class,
})
public class DruidConfiguration {

	@Autowired
	private MasterdataDataSourceProperties masterdataDataSourceProperties;

	@Bean(name = "masterDatasource", initMethod = "init", destroyMethod = "close")
	@Primary
	public DataSource masterDatasource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(masterdataDataSourceProperties.getDriver());
		druidDataSource.setUrl(masterdataDataSourceProperties.getUrl());
		druidDataSource.setUsername(masterdataDataSourceProperties.getUsername());
		druidDataSource.setPassword(masterdataDataSourceProperties.getPassword());
		druidDataSource.setInitialSize(5);
		druidDataSource.setMinIdle(50);
		druidDataSource.setMaxActive(50);
		druidDataSource.setTimeBetweenEvictionRunsMillis(3000);
		druidDataSource.setMinEvictableIdleTimeMillis(300000);
		druidDataSource.setValidationQuery("SELECT 1");
		druidDataSource.setTestWhileIdle(true);
		druidDataSource.setTestOnBorrow(false);
		druidDataSource.setTestOnReturn(false);
		return druidDataSource;
	}

}
