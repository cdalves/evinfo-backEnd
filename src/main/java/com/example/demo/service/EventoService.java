package com.example.demo.service;

import com.example.demo.domain.Evento;
import com.example.demo.repository.EventoRepository;
import com.example.demo.request.EventoPostRequestBody;
import com.example.demo.request.EventoPutRequestBody;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;


    public List<Evento> listAll(){
        return eventoRepository.findAll();
    }


    public Evento findByIdOrThrowBadRequestException(long id) {
        return eventoRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Evento não encontrado"));
    }

    public Evento save(EventoPostRequestBody eventoPostRequestBody){
        return eventoRepository.save(Evento.builder().nome(eventoPostRequestBody.getName()).build());
    }

    public void delete(long id) {
        eventoRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(EventoPutRequestBody eventoPutRequestBody) {
        findByIdOrThrowBadRequestException(eventoPutRequestBody.getId());
        Evento evento = Evento.builder()
                        .id(eventoPutRequestBody.getId())
                        .nome(eventoPutRequestBody.getName())
                        .build();
        eventoRepository.save(evento);
    }
}