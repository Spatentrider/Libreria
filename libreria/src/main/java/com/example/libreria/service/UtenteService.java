package com.example.libreria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.libreria.model.Utente;
import com.example.libreria.repository.UtenteRepository;

public class UtenteService {

        private final UtenteRepository repo;
public UtenteService(UtenteRepository repo){
    this.repo = repo;
} 


public List<Utente> getAll() {
List<Utente> lista = new ArrayList<>();
repo.findAll().forEach(lista::add);
return lista;
}

public Optional<Utente> getById(Long id) {
return repo.findById(id);
}

public Utente create(Utente nuovo) {
return repo.save(nuovo);
}

public Optional<Utente> update(Long id, Utente modificato) {
return repo.findById(id).map(t -> {
t.setNome(modificato.getNome());
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
