package com.gcu.clc;

import com.gcu.clc.business.LoginBusinessService;
import com.gcu.clc.business.RegistrationBusinessService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean(name = "loginBusinessService", initMethod = "init", destroyMethod = "destroy")

    public LoginBusinessService getLoginBusinessService() {
        return new LoginBusinessService();
    }

    @Bean(name = "registrationBusinessService", initMethod = "init", destroyMethod = "destroy")
    public RegistrationBusinessService getRegistrationBusinessService() {
        return new RegistrationBusinessService();
    }
}
