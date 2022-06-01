package com.letscode.vendasapi.gateway;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class UsuarioGateway {

    private final UsuarioReactiveFeignClient usuarioReactiveFeignClient;

    public Mono<String> getUsuario(String id){
        return usuarioReactiveFeignClient.getUsuario(id)
                .onErrorResume(FeignException.NotFound.class, erro ->
                        Mono.empty()
                );
    }
}
