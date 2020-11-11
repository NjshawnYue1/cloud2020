package cn.ga.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月11日 14:01:00
 */
@RestController
public class HelloController {

    @Value(value = "${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    @Value(value = "${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return restTemplate.getForObject(serviceUrl + "/echo/" + string, String.class);
    }
}

