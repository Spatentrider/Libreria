package com.example.libreria.controller;

import com.example.libreria.model.Autore;
import com.example.libreria.service.AutoreService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autori")
public class AutoreController {

    private final 
    AutoreService service;

    public AutoreController(AutoreService service) {
        this.service = service;
    }

    @GetMapping
    public List<Autore> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autore> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Autore> create(@RequestBody Autore nuovo) {
        Autore creato = service.create(nuovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autore> update(@PathVariable Long id, @RequestBody Autore modificato) {
        return service.update(id, modificato)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean rimosso = service.delete(id);
        return rimosso ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}