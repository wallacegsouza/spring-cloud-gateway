package br.com.wgs.gateway.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.stereotype.Component;

@Component
public class ServiceLocatorBuilder {

    @Autowired
    RouteLocatorBuilder builder;

    // ENV
    private String httpbin = "http://httpbin.org:80";
    private String token = "asdfsdf";

    public RouteLocator getLocator() {
        return builder.routes()
            .route(p ->
                p.path("/get")
                .filters(f -> f.addRequestHeader("Hello", "World"))
                .uri(httpbin)
            )
            .route(p ->
                p.path("/status/*")
                .filters(f -> f.addRequestHeader("Authorization", "Bearer " + token))
                .uri(httpbin)
            )
        .build();
    }
    
}
