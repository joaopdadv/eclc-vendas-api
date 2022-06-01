package com.letscode.vendasapi.handler;

import com.letscode.vendasapi.domain.Venda;
import com.letscode.vendasapi.repository.VendasRepository;
import com.letscode.vendasapi.service.VendasService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class VendasHandler {

    private final VendasRepository vendasRepository;
    private final VendasService vendasService;

    public VendasHandler(VendasRepository vendasRepository, VendasService vendasService) {
        this.vendasRepository = vendasRepository;
        this.vendasService = vendasService;
    }

    public Mono<ServerResponse> registraVenda(
            ServerRequest request
    ){
        return request.bodyToMono(Venda.class)
                .flatMap(vendasService::registraVenda)
                .flatMap(vendasRepository::save)
                .flatMap(venda -> ServerResponse
                        .created(URI.create(String.format("/venda/%s", venda.getId())))
                        .bodyValue(venda)
                )
                .switchIfEmpty(ServerResponse
                        .unprocessableEntity()
                        .bodyValue("Requisição inválida, tente novamente."));
    }
}
