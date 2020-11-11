package cn.ga.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月11日 14:39:00
 */
@RestController
//动态刷新 修改配置中心的内容可以直接获取到最新的
@RefreshScope
public class HelloController {
    @Value(value = "${config.info}")
    private String configInfo;

    @GetMapping("/nacos/config/info")
    public String hello() {
        return configInfo;
    }
}
