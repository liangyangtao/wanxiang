//package com.unbank.web.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import redis.clients.jedis.JedisPoolConfig;
//
//@Configuration
//@EnableTransactionManagement
//@ComponentScan({ "com.unbank.web.configuration" })
//@PropertySource(value = { "classpath:application.properties" })
//public class JRedisConfiguration {
//
//	@Autowired
//	private Environment environment;
//
//	@Bean
//	JedisPoolConfig poolConfig() {
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		jedisPoolConfig.setMaxTotal(Integer.parseInt(environment.getRequiredProperty("redis.maxTotal")));
//		jedisPoolConfig.setMaxIdle(Integer.parseInt(environment.getRequiredProperty("redis.maxIdle")));
//		jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(environment.getRequiredProperty("redis.maxWait")));
//		jedisPoolConfig.setTestOnBorrow(Boolean.parseBoolean(environment.getRequiredProperty("redis.testOnBorrow")));
//		return jedisPoolConfig;
//	}
//
//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//		jedisConnectionFactory.setHostName(environment.getRequiredProperty("redis.host"));
//		jedisConnectionFactory.setPort(Integer.parseInt(environment.getRequiredProperty("redis.port")));
//		jedisConnectionFactory.setPassword(environment.getRequiredProperty("redis.pass"));
//		jedisConnectionFactory.setDatabase(Integer.parseInt(environment.getRequiredProperty("redis.dbIndex")));
//		jedisConnectionFactory.setPoolConfig(poolConfig());
//		return jedisConnectionFactory;
//	}
//
//	@Bean
//	StringRedisTemplate stringRedisTemplate() {
//		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//		stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
//		stringRedisTemplate.setEnableTransactionSupport(true);
//		
//		return stringRedisTemplate;
//
//	}
//	
//	@Bean
//	RedisCacheManager redisCacheManager (){
//		RedisCacheManager redisCacheManager = new RedisCacheManager(stringRedisTemplate());
//		redisCacheManager.setDefaultExpiration(Integer.parseInt(environment.getRequiredProperty("redis.expiration")));
//		return redisCacheManager;
//	}
//
//}
