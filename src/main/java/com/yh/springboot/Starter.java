package com.yh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication //等同于默认的属性的 @Configuration, @EnableAutoConfiguration and @ComponentScan
@PropertySource(value = "classpath:application.properties")
@EnableAutoConfiguration
//@EnableEncryptableProperties
//@EnableElasticsearchRepositories(basePackages = { "com.yonghui.b2b.spider.spiderdb.es" })
//@EnableRedisRepositories(basePackages = { "com.yonghui.b2b.spider.spiderdb.redis" })
//@MapperScan("com.yonghui.b2b.spider.spiderdb.md.dao")
public class Starter {

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}
}
