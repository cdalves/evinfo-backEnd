package com.example.demo.request;

import lombok.Data;

@Data
public class UsuarioPutRequestBody {
    private Long id;
    private String name;
    private String email;
}
