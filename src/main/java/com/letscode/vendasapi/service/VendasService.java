package com.letscode.vendasapi.service;

import com.letscode.vendasapi.domain.Venda;
import com.letscode.vendasapi.gateway.ProdutosGateway;
import com.letscode.vendasapi.gateway.UsuarioGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class VendasService {

    private final ProdutosGateway produtosGateway;
    private final UsuarioGateway usuarioGateway;

    public VendasService(ProdutosGateway produtosGateway, UsuarioGateway usuarioGateway) {
        this.produtosGateway = produtosGateway;
        this.usuarioGateway = usuarioGateway;
    }

    public Mono<Venda> registraVenda(Venda venda){
        return Mono.zip(
                Mono.just(venda).flatMap(v -> usuarioGateway.getUsuario(v.getUserId())),
                Mono.just(venda).flatMap(v -> usuarioGateway.getUsuario(v.getUserId()))
        ).thenReturn(venda);
    }
}
