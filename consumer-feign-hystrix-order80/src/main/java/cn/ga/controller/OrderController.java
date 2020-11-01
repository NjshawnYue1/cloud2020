package cn.ga.controller;

import cn.ga.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月01日 17:52:00
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "paymentTimeoutGlobalHandler")
@RequestMapping("consumer/payment/hystrix")
public class OrderController {

    @Resource
    OrderService orderService;

    @GetMapping("ok")
    public String isOk(){
        return orderService.isOk();
    }
//    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//            }
//    )
//    @HystrixCommand
    @GetMapping("timeout")
    public String timeout(){
        return orderService.timeout();
    }

    public String paymentTimeoutHandler() {
        return "当前线程" + Thread.currentThread().getName() + " 请求失败 ";
    }

    // 全局fallback
    public String paymentTimeoutGlobalHandler() {
        return "当前线程" + Thread.currentThread().getName() + " 全局降级，请求失败 ";
    }

}
