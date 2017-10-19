package com.zirxin.jalpha_vantage.config;

import com.zirxin.jalpha_vantage.service.CryptoCurrencyOperation;
import com.zirxin.jalpha_vantage.service.StockOperation;
import com.zirxin.jalpha_vantage.service.TechnicalIndicatorOperation;
import com.zirxin.jalpha_vantage.service.impl.CryptoCurrencyTemplate;
import com.zirxin.jalpha_vantage.service.impl.StockTemplate;
import com.zirxin.jalpha_vantage.service.impl.TechnicalIndicatorTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsAsyncClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.zirxin.jalpha_vantage.service"})
public class AppConfig {

    private final String apiKey = "1AC06VRKR36YJAND";

    @Bean
    StockOperation stockOperation() {
        return new StockTemplate(restTemplate(), apiKey);
    }

    @Bean
    CryptoCurrencyOperation cryptoCurrencyOperation() {
        return new CryptoCurrencyTemplate(restTemplate(), apiKey);
    }

    @Bean
    TechnicalIndicatorOperation technicalIndicatorOperation() {
        return new TechnicalIndicatorTemplate(restTemplate(), apiKey);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate(new HttpComponentsAsyncClientHttpRequestFactory());
    }

}
