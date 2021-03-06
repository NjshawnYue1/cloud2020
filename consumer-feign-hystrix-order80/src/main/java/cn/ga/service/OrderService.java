package cn.ga.service;

import cn.ga.service.impl.OrderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月01日 17:46:00
 */
@Component
@FeignClient(value = "PROVIDER-HYSTRIX-PAYMENT",fallback = OrderServiceImpl.class)
public interface OrderService {

    @GetMapping("/payment/hystrix/ok")
    public String isOk();

    @GetMapping("/payment/hystrix/timeout")
    public String timeout();
}
