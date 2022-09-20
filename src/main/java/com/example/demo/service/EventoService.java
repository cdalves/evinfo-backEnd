package com.example.demo.service;

import com.example.demo.domain.Evento;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EventoService {
    private List<Evento> eventos = List.of(new Evento(1L, 123L, "Concerto de música classica", "Concerto com apresentação de peças dos maiores compositores", "30/10/2022"), new Evento(2L, 321L, "Exposição de artes", "Exposição de artes para artistas regionais", "07/11/2022"));

    // private final AnimeRepository animeRepository;
    public List<Evento> listAll() {
        return eventos;
    }

    public Evento findById(long id) {
        return eventos.stream()
                .filter(evento -> evento.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Evento não encontrado"));
    }
}
