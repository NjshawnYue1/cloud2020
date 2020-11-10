package cn.ga.service.impl;

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


    /**
     * 参数与fallback一直,所谓熔断就执行结果是来看，长时间尝试请求都获得失败且满足了设定的参数，比如下方的10s内10次60%的失败率
     * 则会触发熔断，熔断后就是请求不发生异常也会返回fallback方法结果(半熔断)，知道正常率逐渐上升，错误率降低，这是才会恢复调用链路
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 请求单位窗口
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率
    })
    public String paymentCircuitBreakerOk(Integer id) {
        if (id < 0) {
            throw new RuntimeException();
        }
        return "当前线程" + Thread.currentThread().getName() + " ok ";
    }

    private String paymentCircuitBreakerFallback(Integer id) {
        return "失败了 (灬ꈍ ꈍ灬)" + id;
    }

}
