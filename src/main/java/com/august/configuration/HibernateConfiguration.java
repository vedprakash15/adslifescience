package com.august.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = "com.august.configuration")
public class HibernateConfiguration {

	@Autowired
	PropertyConfig propertyConfig;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		try {
			System.out.println("Insie try");
			sessionFactory.setDataSource(propertyConfig.dataSource());
			sessionFactory.setPackagesToScan(new String[] { "com.august.v1.domain.entity" });
			sessionFactory.setHibernateProperties(propertyConfig.hibernateProperties());
		} catch (IllegalStateException ex) {
			System.out.println("Unable to obtaion database connection");
			System.out.println(ex.getMessage());
		}

		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txnManager = new HibernateTransactionManager();
		try {
		txnManager.setSessionFactory(s);
		}catch(Exception e){
			System.err.println("txn ex : " + e.getMessage());
		}
		return txnManager;
	}
}
