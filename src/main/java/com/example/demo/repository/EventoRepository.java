package com.example.demo.repository;

import com.example.demo.domain.Evento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
    List<Evento> findByName(String name);
}
