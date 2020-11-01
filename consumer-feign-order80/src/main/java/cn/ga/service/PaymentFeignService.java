package cn.ga.service;

import cn.ga.entity.Payment;
import cn.ga.rest.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 在service直接调用controller中的方法
 * @author GuAn
 * @Description
 * @createTime 2020年11月01日 14:39:00
 */
@Component
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignService {
    /**
     * 新增
     * @param payment
     * @return
     */
    @PostMapping("/payment/add")
    public CommonResult<Boolean> addPayment(Payment payment);

    /**
     * id查询
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 查所有
     * @return
     */
    @GetMapping("/payment/list")
    public CommonResult<List> getAll();

    @GetMapping("/payment/timeout")
    public String getTimeout();
}
