package com.Qiu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.Qiu.controller","com.Qiu.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
