package com.example.demo.mapper;

import com.example.demo.domain.Usuario;
import com.example.demo.request.UsuarioPostRequestBody;
import com.example.demo.request.UsuarioPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {
    public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    public abstract Usuario toUsuario(UsuarioPostRequestBody usuarioPostRequestBody);

    public abstract Usuario toUsuario(UsuarioPutRequestBody usuarioPostRequestBody);
}
