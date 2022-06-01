package com.letscode.vendasapi.gateway;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProdutosGateway {

    private final ProdutosReactiveFeignClient produtosReactiveFeignClient;

    public Mono<String> getProduto(Long id){
        return produtosReactiveFeignClient.getProduto(id)
                .onErrorResume(FeignException.NotFound.class, erro ->
                        Mono.empty()
                );
    }
}
