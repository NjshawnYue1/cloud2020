package cn.ga.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author GuAn
 * @Description
 * @createTime 2020年11月11日 13:01:00
 */
@Component
@Slf4j
public class MyLogGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("当前被过滤请求为: [ {} ]",exchange.getRequest().getURI());
        if(exchange.getRequest().getQueryParams().get("name") != null){
            return chain.filter(exchange);

        }else {
            log.warn("当前请求用户未登录");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
    }

    /**
     * 加载顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
