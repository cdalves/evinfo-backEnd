package com.example.demo.controller;

import com.example.demo.domain.Evento;
import com.example.demo.service.EventoService;
import com.example.demo.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("eventos")
@Log4j2
@RequiredArgsConstructor
public class EventoController {
    private final DateUtil dateUtil;
    private final EventoService eventoService;

    @GetMapping
    public ResponseEntity<List<Evento>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(eventoService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Evento> findById(@PathVariable long id){
        return ResponseEntity.ok(eventoService.findById(id));
    }
}
