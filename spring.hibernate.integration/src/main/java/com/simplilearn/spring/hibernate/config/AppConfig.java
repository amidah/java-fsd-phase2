package com.simplilearn.spring.hibernate.config;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public class AppConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		return null;
	}
	
//	 <property name="connection.url">jdbc:mysql://127.0.0.1:3307/employee?useSSL=false</property>
//	        <property name="connection.username">root</property>
//	        <property name="connection.password">root123</property>
//	        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
	@Bean
	public DataSource datasource() {
		BasicDataSource basicDataSource =  new BasicDataSource();
		basicDataSource.setDriverClassName("");
		return null;
	}

}
