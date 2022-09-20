package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Evento {
    private Long id;
    private Long idUser;
    private String nome;
    private String descricao;
    private String data;
    


}
