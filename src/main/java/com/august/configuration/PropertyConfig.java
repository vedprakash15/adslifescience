package com.august.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;



@ComponentScan(basePackages = "com.august.configuration")
@PropertySources({ @PropertySource("classpath:applicationConfig.properties")})
@Component
public class PropertyConfig {

	@Autowired
	Environment enviroment;
	
	public DataSource dataSource() {
		System.out.println("Inside Data Source");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println(enviroment.getRequiredProperty("hibernate.driverClass"));
		System.out.println(enviroment.getRequiredProperty("jdbc.url"));
		System.out.println(enviroment.getRequiredProperty("hibernate.username"));
		System.out.println(enviroment.getRequiredProperty("hibernate.password"));
		System.out.println("below sysout");
		dataSource.setUrl(enviroment.getRequiredProperty("jdbc.url"));
		System.out.println("1");
		dataSource.setDriverClassName(enviroment.getRequiredProperty("hibernate.driverClass"));
		System.out.println("2");
		dataSource.setUsername(enviroment.getRequiredProperty("hibernate.username"));
		System.out.println("3");
		dataSource.setPassword(enviroment.getRequiredProperty("hibernate.password"));
		System.out.println("4");
		System.out.println("Data Source retuen");
		return dataSource;
		
	}
	
	
	public Properties hibernateProperties() {
		System.out.println("Inside HBM Pro");
		Properties property = new Properties();
		property.put("hibernate.dialect", enviroment.getRequiredProperty("hibernate.dialect"));
		property.put("hibernate.show_sql", enviroment.getRequiredProperty("hibernate.show_sql"));
		property.put("hibernate.hbm2ddl.auto", enviroment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return property;
	}
	
	public Environment getEnviroment() {
		return enviroment;
	}
	
}
