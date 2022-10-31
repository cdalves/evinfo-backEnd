package com.example.demo.mapper;

import com.example.demo.domain.Evento;
import com.example.demo.request.EventoPostRequestBody;
import com.example.demo.request.EventoPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EventoMapper {
    public static final EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);

    public abstract Evento toEvento(EventoPostRequestBody eventoPostRequestBody);

    public abstract Evento toEvento(EventoPutRequestBody eventoPostRequestBody);
}
