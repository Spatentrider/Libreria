package com.example.libreria.service;


import com.example.libreria.model.Autore;
import com.example.libreria.repository.AutoreRepository;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AutoreService {

private final AutoreRepository repo;

public AutoreService(AutoreRepository repo){
    this.repo = repo;
} 


public List<Autore> getAll() {
List<Autore> lista = new ArrayList<>();
repo.findAll().forEach(lista::add);
return lista;
}

public Optional<Autore> getById(Long id) {
return repo.findById(id);
}

public Autore create(Autore nuovo) {
return repo.save(nuovo);
}

public Optional<Autore> update(Long id, Autore modificato) {
return repo.findById(id).map(t -> {
t.setName(modificato.getName());
return repo.save(t);
});
}

public boolean delete(Long id) {
if (repo.existsById(id)) {
repo.deleteById(id);
return true;
}
return false;
}
}
