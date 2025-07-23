package com.example.libreria.controller;

import com.example.libreria.model.Recensione;
import com.example.libreria.service.RecensioneService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recensioni")
public class RecensioneController {

    private final 
    RecensioneService service;

    public RecensioneController(RecensioneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Recensione> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recensione> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Recensione> create(@RequestBody Recensione nuovo) {
        Recensione creato = service.create(nuovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recensione> update(@PathVariable Long id, @RequestBody Recensione modificato) {
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
