package cn.ga.controller;

import cn.ga.entity.Payment;
import cn.ga.rest.CommonResult;
import cn.ga.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年10月31日 13:40:00
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("add")
    public CommonResult<Boolean> addPayment(@RequestBody Payment payment) {
        boolean b = paymentService.addPayment(payment);
        CommonResult<Boolean> commonResult = new CommonResult<>();
        if (b) {
            commonResult.setCode(200);
            commonResult.setMessage("新增成功");
            commonResult.setData(b);
        } else {
            commonResult.setCode(400);
            commonResult.setMessage("新增失败");
        }
        return commonResult;
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        Optional<Payment> optionalPayment = Optional.ofNullable(payment);
        CommonResult<Payment> commonResult = new CommonResult<>();
        if (optionalPayment.isPresent()) {
            commonResult.setCode(200);
            commonResult.setData(payment);
            commonResult.setMessage("查询成功");
            log.info("查询到的记录是----{}" + serverPort, payment);
        } else {
            commonResult.setCode(400);
            commonResult.setMessage("没有这条记录,查询的id为: " + id);
        }
        return commonResult;
    }


    @GetMapping("list")
    public CommonResult<List> getPayments() {
        List<Payment> payments = paymentService.getAll();
        CommonResult<List> commonResult = new CommonResult<>();
        commonResult.setCode(200);
        commonResult.setData(payments);
        commonResult.setMessage("查询成功");
        log.info("查询到的记录是----{}" + serverPort, payments);
        return commonResult;
    }
}
