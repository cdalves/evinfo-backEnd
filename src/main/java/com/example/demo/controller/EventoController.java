package com.example.demo.controller;

//importe da classe eventos 
import com.example.demo.domain.Evento;
import com.example.demo.request.EventoPostRequestBody;
import com.example.demo.request.EventoPutRequestBody;
import com.example.demo.service.EventoService;
import com.example.demo.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/eventos")
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
    public ResponseEntity<Evento> findById(@PathVariable Long id){
        return ResponseEntity.ok(eventoService.findByIdOrThrowBadRequestException(id));

    }

    //http://localhost:8080/eventos/find/?name=fest como usar o find
    @GetMapping(path = "/find")
    public ResponseEntity<List<Evento>> findByName(@RequestParam String name){
        return ResponseEntity.ok(eventoService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Evento> save(@RequestBody @Valid EventoPostRequestBody eventoPostRequestBody){
        return new ResponseEntity<>(eventoService.save(eventoPostRequestBody), HttpStatus.CREATED); 
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        eventoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody @Valid EventoPutRequestBody eventoPutRequestBody) {
        eventoService.replace(eventoPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
