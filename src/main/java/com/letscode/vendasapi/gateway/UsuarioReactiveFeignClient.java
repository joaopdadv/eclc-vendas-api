package com.letscode.vendasapi.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "usuarios-service")
public interface UsuarioReactiveFeignClient {

    @GetMapping("/usuario/{usuarioId}")
    Mono<String> getUsuario(@PathVariable("usuarioId") String usuarioId);

}
