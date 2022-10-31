package com.example.demo.controller;

import com.example.demo.domain.Usuario;
import com.example.demo.request.UsuarioPostRequestBody;
import com.example.demo.request.UsuarioPutRequestBody;
import com.example.demo.service.UsuarioService;
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
@RequestMapping("usuario")
@Log4j2
@RequiredArgsConstructor
public class UsuarioController {
    private final DateUtil dateUtil;
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(usuarioService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable long id){
        return ResponseEntity.ok(usuarioService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody UsuarioPostRequestBody usuarioPostRequestBody){
        return new ResponseEntity<>(usuarioService.save(usuarioPostRequestBody), HttpStatus.CREATED); 
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(long id) {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody UsuarioPutRequestBody usuarioPutRequestBody) {
        usuarioService.replace(usuarioPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
