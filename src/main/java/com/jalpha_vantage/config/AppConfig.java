package com.jalpha_vantage.config;

import com.jalpha_vantage.service.IStockService;
import com.jalpha_vantage.service.impl.CryptoCurrencyTemplate;
import com.jalpha_vantage.service.impl.StockTemplate;
import com.jalpha_vantage.service.impl.TechnicalIndicatorTemplate;
import com.jalpha_vantage.service.ICryptoCurrencyService;
import com.jalpha_vantage.service.ITechnicalIndicatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.jalpha_vantage.service"})
public class AppConfig {

    private final String apiKey = "1AC06VRKR36YJAND";


    @Bean
    ICryptoCurrencyService cryptoCurrencyOperation() {
        return new CryptoCurrencyTemplate(restTemplate(), apiKey);
    }

    @Bean
    ITechnicalIndicatorService technicalIndicatorOperation() {
        return new TechnicalIndicatorTemplate(restTemplate(), apiKey);
    }

    @Bean
    IStockService stockOperation(){
        return new StockTemplate(restTemplate(),apiKey);
    }


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate(new HttpComponentsAsyncClientHttpRequestFactory());
    }

}
