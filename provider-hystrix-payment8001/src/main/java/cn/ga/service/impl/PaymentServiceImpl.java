package cn.ga.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import cn.ga.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月01日 16:58:00
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentOk() {
        return "当前线程" + Thread.currentThread().getName() + " ok ";
    }

    @HystrixCommand(fallbackMethod = "paymentTimeoutHandler",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            }
    )
    @Override
    public String paymentTimeout() {
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程" + Thread.currentThread().getName() + " timeout ";
    }

    public String paymentTimeoutHandler() {
        return "当前线程" + Thread.currentThread().getName() + " 请求失败 ";
    }
}
