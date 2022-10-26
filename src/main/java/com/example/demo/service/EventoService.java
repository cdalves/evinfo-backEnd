package com.example.demo.service;

import com.example.demo.domain.Evento;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class EventoService {
    private static List<Evento> eventos;

    static{
        eventos = new ArrayList<>(List.of(new Evento(1L, 123L, "Concerto de música classica", "Concerto com apresentação de peças dos maiores compositores", "30/10/2022"), new Evento(2L, 321L, "Exposição de artes", "Exposição de artes para artistas regionais", "07/11/2022")));
    }

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

    public Evento save(Evento evento){
        evento.setId(ThreadLocalRandom.current().nextLong(3, 100000));
        eventos.add(evento);
        return evento;
    }

    public void delete(long id) {
        eventos.remove(findById(id));
    }

    public void replace(Evento evento) {
        delete(evento.getId());
        eventos.add(evento);
    }
}
