package com.andries.spring.config;

import com.andries.services.api.controllers.Controllers;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Andries on 8/17/16.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {
        Controllers.class
})
public class SpringWebConfig {

}
