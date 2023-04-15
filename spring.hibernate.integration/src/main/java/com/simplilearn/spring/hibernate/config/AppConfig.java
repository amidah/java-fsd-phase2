package com.simplilearn.spring.hibernate.config;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@ComponentScan("com.simplilearn.spring.hibernate")
@EnableTransactionManagement
public class AppConfig {

  @Bean
  public LocalSessionFactoryBean sessionFactory () {

    LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
    localSessionFactoryBean.setDataSource(datasource());
    localSessionFactoryBean.setHibernateProperties(hibernateProperties());
    localSessionFactoryBean.setPackagesToScan("com.simplilearn.spring.hibernate.models");

    return localSessionFactoryBean;
  }


  @Bean
  public PlatformTransactionManager hibernateTransactionManager () {

    HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
    return hibernateTransactionManager;
  }


  // <property name="hbm2ddl.auto">update</property>
//        <property name="dialect">org.hibernate.dialect.MySQL8Dialect</property>
//        <property name="connection.url">jdbc:mysql://127.0.0.1:3307/employee?useSSL=false</property>
//        <property name="connection.username">root</property>
//        <property name="connection.password">root123</property>
//        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property>
//        <property name="show_sql">true</property>
  @Bean
  public DataSource datasource () {

    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3307/employee?allowPublicKeyRetrieval=true&useSSL=false");
    basicDataSource.setUsername("root");
    basicDataSource.setPassword("root123");
    return basicDataSource;
  }


  @Bean
  public Properties hibernateProperties () {

    Properties properties = new Properties();
    properties.setProperty("hibernate.show_sql", "true");
    properties.setProperty("hibernate.hbm2ddl.auto", "update");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
    return properties;
  }

}
