package cn.ga.controller;

import cn.ga.entity.Payment;
import cn.ga.rest.CommonResult;
import cn.ga.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月01日 14:43:00
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

    @Resource
    PaymentFeignService paymentFeignService;

    @GetMapping("list")
    public CommonResult getAll(){
        return paymentFeignService.getAll();
    }

    @PostMapping("/add")
    public CommonResult<Boolean> addPayment(Payment payment){
        return paymentFeignService.addPayment(payment);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("timeout")
    public String getTimeout(){
        return paymentFeignService.getTimeout();
    }
}
