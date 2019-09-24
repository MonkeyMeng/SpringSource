package com.monkey.myspring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.monkey.myspring")
@Conditional(DefaultCondition.class)
public class AppConfig {


}
