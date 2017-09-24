package com.alpha_vantage.api.config;

import com.alpha_vantage.api.service.CryptoCurrencyOperation;
import com.alpha_vantage.api.service.StockOperation;
import com.alpha_vantage.api.service.TechnicalIndicatorOperation;
import com.alpha_vantage.api.service.impl.CryptoCurrencyTemplate;
import com.alpha_vantage.api.service.impl.StockTemplate;
import com.alpha_vantage.api.service.impl.TechnicalIndicatorTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.alpha_vantage.api.service"})
public class AppConfig {

    private final String apiKey = "1AC06VRKR36YJAND";

    @Bean
    StockOperation stockOperation(){
        return new StockTemplate(restTemplate(),apiKey);
    }

    @Bean
    CryptoCurrencyOperation cryptoCurrencyOperation(){
        return new CryptoCurrencyTemplate(restTemplate(), apiKey);
    }

    @Bean
    TechnicalIndicatorOperation technicalIndicatorOperation(){
        return new TechnicalIndicatorTemplate(restTemplate(),apiKey);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate(new HttpComponentsAsyncClientHttpRequestFactory());
    }

}
