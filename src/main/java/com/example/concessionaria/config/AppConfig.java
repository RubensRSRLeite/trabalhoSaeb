package com.example.concessionaria.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class AppConfig {

	@Bean
    public DataSource dataSource() {
        
        DriverManagerDataSource drivManargerDataSource = new DriverManagerDataSource();
        drivManargerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");// DRIVER DE CONEXÃO COM O BD
        drivManargerDataSource.setUrl("jdbc:mysql://localhost:3306/concessionaria");
        drivManargerDataSource.setUsername("root");
        drivManargerDataSource.setPassword("root");	
        
        return drivManargerDataSource;
    }



    // BIBLIOTECA DE PERSISTENCIA DO JAVA, JPA
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);// TIPO DE DATABASE
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");// ESPECIFICAR O DIALETO QUE SERÁ USADO PARA CONVERSAR COM A DATABASE, MySQL8Dialect LINGUAGEM QUE VAI SER USADA
        adapter.setPrepareConnection(true);// PREPARAR A CONEXÃO PARA MANDAR INSTRUÇÕES
        adapter.setGenerateDdl(true);// GERAR O DDL, SERIA FALSO SE A TABELA  JÁ EXISTISSE
        adapter.setShowSql(true);// TODAS AS APLICAÇÕES SQL APARECERA NO CONSOLE, PARA CONTROLAR O QUE ESTÁ ACONTECENDO, UM INFORMATIVO
        
        return adapter;
    }
	
}
