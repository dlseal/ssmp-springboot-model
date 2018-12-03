package com.ssm;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;

@SpringBootConfiguration
@MapperScan("com.ssm.mapper")
public class MybatisPlusConfig {
	
	@Bean
	@ConditionalOnMissingBean
	public MybatisSqlSessionFactoryBean getmyBatisSqlSessionFactory(DataSource dataSource) {
		MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
		mybatisSqlSessionFactoryBean.setDataSource(dataSource);
		/**
		 *mybatis的配置文件，如果需要一些配置打开即可 
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource mybatisXml = resolver.getResource("classpath:mybatis-config.xml");
		mybatisSqlSessionFactoryBean.setConfigLocation(mybatisXml);
		 */
		return mybatisSqlSessionFactoryBean;
		
	}
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		paginationInterceptor.setDialectType("mysql");
		return paginationInterceptor;
	}
}
