package com.letscode.vendasapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document("venda")
public class Venda {

    @Id
    private String id;

    private String userId;
    private Double valor;

    @Field
    List<Long> idProdutos = new ArrayList<>();

    private Date data = new Date();
}
