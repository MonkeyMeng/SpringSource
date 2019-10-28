package com.monkey.myspring.ciculardependency;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@Configuration
@ComponentScan("com.monkey.myspring.ciculardependency")
@Import(A.class)
public class Config {
}
