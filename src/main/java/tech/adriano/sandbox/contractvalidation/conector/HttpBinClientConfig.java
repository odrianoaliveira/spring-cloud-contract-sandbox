package tech.adriano.sandbox.contractvalidation.conector;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Setter
@Configuration
public class HttpBinClientConfig {
    @Value("${httpbin.url}")
    private String httpBinUrl;

    @Bean
    public HttpBinClient httpBinClient() {
        return Feign.builder()
                    .encoder(new JacksonEncoder())
                    .decoder(new JacksonDecoder())
                    .target(HttpBinClient.class, httpBinUrl);
    }
}
