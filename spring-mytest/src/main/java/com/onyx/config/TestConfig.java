package com.onyx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.onyx")

//如果需要制定BeanName生成器, 需要制定出来
//@ComponentScan(value = "com.onyx", nameGenerator = MyBeanNameGenerator.class)

@Configuration
public class TestConfig {

}
