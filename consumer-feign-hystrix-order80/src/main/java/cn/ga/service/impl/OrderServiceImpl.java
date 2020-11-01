package cn.ga.service.impl;

import cn.ga.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月01日 19:35:00
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public String isOk() {
            return "当前线程" + Thread.currentThread().getName() + " 全局降级，请求失败 ";

    }

    @Override
    public String timeout() {
        return "当前线程" + Thread.currentThread().getName() + " 全局降级，请求失败 ";

    }
}
