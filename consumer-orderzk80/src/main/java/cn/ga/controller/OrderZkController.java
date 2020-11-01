package cn.ga.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年10月31日 18:16:00
 */
@RestController
@Slf4j
public class OrderZkController {

    @Resource
    private RestTemplate restTemplate;

    public static final String INVOKE_URL = "http://provider-payment/";

    @GetMapping("/consumer/payment/zk")
    public String get() {
       return restTemplate.getForObject(INVOKE_URL + "payment/zk",String.class);
    }
}
