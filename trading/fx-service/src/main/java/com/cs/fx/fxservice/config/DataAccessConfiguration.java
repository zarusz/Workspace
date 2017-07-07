package com.cs.fx.fxservice.config;

import com.cs.fx.dataaccess.MockCurrencyRepository;
import com.cs.fx.dataaccess.MockCustomerRepository;
import com.cs.fx.dataaccess.MockLegalEntityRepository;
import com.cs.fx.dataaccess.MockScheduleService;
import com.cs.fx.domainmodel.CurrencyRepository;
import com.cs.fx.domainmodel.CustomerRepository;
import com.cs.fx.domainmodel.LegalEntityRepository;
import com.cs.fx.domainmodel.ScheduleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Tomasz on 07.07.2017.
 */
@Configuration
public class DataAccessConfiguration {

    @Bean
    public CustomerRepository customerRepository() {
        return new MockCustomerRepository();
    }

    @Bean
    public LegalEntityRepository legalEntityRepository() {
        return new MockLegalEntityRepository();
    }

    @Bean
    public ScheduleService scheduleService() {
        return new MockScheduleService();
    }

    @Bean
    public CurrencyRepository currencyRepository() {
        return new MockCurrencyRepository();
    }
}
