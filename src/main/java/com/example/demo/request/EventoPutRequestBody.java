package com.example.demo.request;

import lombok.Data;

@Data
public class EventoPutRequestBody {
    private Long id;
    private String name;
    private Long idUser;
    private String descricao;
    private String data;
}
