package com.letscode.vendasapi.config;

import com.letscode.vendasapi.handler.VendasHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> route(
            VendasHandler vendasHandler
    ){
        return RouterFunctions
                .route(POST("/venda/add").and(contentType(APPLICATION_JSON)), vendasHandler::registraVenda);
    }
}
