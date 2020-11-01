package cn.ga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shawnyue
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ProviderHystrixPayment8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixPayment8001.class, args);
    }

}
