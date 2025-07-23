package com.example.libreria.service;


import com.example.libreria.model.Recensione;
import com.example.libreria.repository.RecensioneRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecensioneService {

    private final RecensioneRepository repo;
public RecensioneService(RecensioneRepository repo){
    this.repo = repo;
} 


public List<Recensione> getAll() {
List<Recensione> lista = new ArrayList<>();
repo.findAll().forEach(lista::add);
return lista;
}

public Optional<Recensione> getById(Long id) {
return repo.findById(id);
}

public Recensione create(Recensione nuovo) {
return repo.save(nuovo);
}

public Optional<Recensione> update(Long id, Recensione modificato) {
return repo.findById(id).map(t -> {
t.setDescrizione(modificato.getDescrizione());
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
