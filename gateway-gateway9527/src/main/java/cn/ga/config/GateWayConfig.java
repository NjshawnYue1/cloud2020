//package cn.ga.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author GuAn
// * @Description
// * @createTime 2020年11月10日 15:03:00
// */
//@Configuration
//public class GateWayConfig {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//
//        RouteLocatorBuilder.Builder routes = builder.routes();
//        return routes
//                .route("payment-service-route1", r -> r.path("/payment/get/**")
//                        .uri("http://localhost:8001/payment/get/**")).build();
//    }
//}
