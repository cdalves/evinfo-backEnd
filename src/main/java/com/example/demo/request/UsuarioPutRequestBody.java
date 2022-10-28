package com.example.demo.request;

import lombok.Data;

@Data
public class UsuarioPutRequestBody {
    private String name;
    private Long id;
    private String email;
}
