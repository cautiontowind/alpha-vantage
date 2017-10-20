package com.zirxin.jalpha_vantage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service("IServiceProvider")
public class ServiceProvider implements  IServiceProvider{

    private final String serviceUri;
    private  final String apiKey;

    @Autowired
    public ServiceProvider(@Value("${alpha_vantage.apikey}")Optional<String> apiKey,
                           @Value("${alpha_vantage.uri}")Optional<String> uri ) {
        this.apiKey = apiKey.orElse("demo");
        this.serviceUri = uri.orElse("http://www.alphavantage.co/query?");
    }


}
