package com.newlecture.web.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@ComponentScan(basePackages= {"com.jaehwan.web.dao.mybatis", "com.newlecture.web.service"})
public class ServiceContextConfig {
	
	
	@Bean
	public BasicDataSource DataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		//MS SQL Server
	    dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://211.238.142.251:1433;databaseName=lecture");
		dataSource.setUsername("sist");
		dataSource.setPassword("dclass");
		
		
		//MySQL or MariaDB
		/*
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://211.238.142.37:3306/newlecturedb?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8");
		dataSource.setUsername("eatchu");
		dataSource.setPassword("soakfaktwlq91");*/
		
		dataSource.setRemoveAbandoned(true);
		dataSource.setInitialSize(20);
		dataSource.setMaxActive(30);
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(BasicDataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver()
				.getResources("classpath:com/jaehwan/web/dao/mybatis/mapper/*.xml")
				);
		
		return sqlSessionFactory.getObject();
		
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		
		return new SqlSessionTemplate(sqlSessionFactory);
		
	}
	
}
