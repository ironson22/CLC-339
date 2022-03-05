package com.gcu.clc;

import com.gcu.clc.business.LoginBusinessService;
import com.gcu.clc.business.ProductBusinessService;
import com.gcu.clc.business.RegistrationBusinessService;
import com.gcu.clc.data.ProductDataService;
import com.gcu.clc.data.RegisterDataService;

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

    @Bean(name = "productBusinessService", initMethod = "init", destroyMethod = "destroy")
    public ProductBusinessService getProductBusinessService() {
        return new ProductBusinessService();
    }
}
