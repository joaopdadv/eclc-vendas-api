package com.letscode.vendasapi.gateway;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "produtos-service")
public interface ProdutosReactiveFeignClient {

    @GetMapping("/produto/{produtoId}")
    Mono<String> getProduto(@PathVariable("produtoId") Long produtoId);

}
