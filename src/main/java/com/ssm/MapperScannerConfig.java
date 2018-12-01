package com.ssm;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootConfiguration
@AutoConfigureAfter(MybatisPlusConfig.class)
@PropertySource(value = { "classpath:application.properties" },ignoreResourceNotFound=true)
public class MapperScannerConfig {
	
	@Value("${mybatis-plus.mapper-locations}")
	private String mapperPackageLocation;
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage(mapperPackageLocation);
		return mapperScannerConfigurer;
	}
}
