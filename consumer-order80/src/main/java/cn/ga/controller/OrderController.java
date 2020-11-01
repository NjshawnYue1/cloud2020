package cn.ga.controller;

import cn.ga.entity.Payment;
import cn.ga.rest.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年10月31日 14:11:00
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

//    private final String PAYMENT_URL = "http://localhost:8001";
    //  使用服务名称之后不再指定到具体的某一个 当多个服务使用同一个名称是就会无法使用 这时候需要额外配置一个【负载均衡】
    private final String PAYMENT_URL = "http://PAYMENT-SERVICE";


    @PostMapping("/payment/add")
    public CommonResult addPayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") String id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/list")
    public CommonResult getPayments() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/list", CommonResult.class);
    }
}
