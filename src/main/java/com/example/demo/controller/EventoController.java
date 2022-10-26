package com.example.demo.controller;

import com.example.demo.domain.Evento;
import com.example.demo.service.EventoService;
import com.example.demo.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public ResponseEntity<Evento> save(@RequestBody Evento evento){
        return new ResponseEntity<>(eventoService.save(evento), HttpStatus.CREATED); 
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        eventoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Evento evento) {
        eventoService.replace(evento);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
