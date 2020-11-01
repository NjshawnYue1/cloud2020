package cn.ga.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年10月31日 14:14:00
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // 【负载均衡】
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
