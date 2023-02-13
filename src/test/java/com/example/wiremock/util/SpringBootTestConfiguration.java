package com.example.wiremock.util;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class SpringBootTestConfiguration {

    @Bean
    public WireMockServer buildWireMockServer(
            @Value("${todoApi.port}") String todoApiPort
    ){
        int port = Integer.parseInt(todoApiPort);
        WireMockConfiguration configuration = WireMockConfiguration.wireMockConfig()
                .port(port)
                .usingFilesUnderClasspath("wiremock");
        return new WireMockServer(configuration);
    }
}
