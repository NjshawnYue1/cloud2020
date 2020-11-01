package cn.ga.controller;

import cn.ga.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月01日 17:01:00
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok")
    public String isOk() {
        return paymentService.paymentOk();
    }

    @GetMapping("/payment/hystrix/timeout")
    public String timeout() {
        return paymentService.paymentTimeout();
    }
}
