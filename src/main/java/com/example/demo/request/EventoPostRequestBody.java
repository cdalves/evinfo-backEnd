package com.example.demo.request;

import lombok.Data;

@Data
public class EventoPostRequestBody {
    private String name;
    private Long id;
    private Long idUser;
    private String descricao;
    private String data;
}
