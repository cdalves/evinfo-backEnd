package com.example.demo.request;

import lombok.Data;

@Data
public class EventoPutRequestBody {
    private String name;
    private Long id;
    private Long idUser;
    private String descricao;
    private String data;
}
