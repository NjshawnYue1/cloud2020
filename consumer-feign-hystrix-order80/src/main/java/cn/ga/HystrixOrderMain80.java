package cn.ga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月01日 17:45:00
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderMain80.class, args);
    }
}
