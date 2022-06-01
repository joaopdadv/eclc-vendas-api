package com.letscode.vendasapi.repository;

import com.letscode.vendasapi.domain.Venda;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends ReactiveMongoRepository<Venda, String> {
}
