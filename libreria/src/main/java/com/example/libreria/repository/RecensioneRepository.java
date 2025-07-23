package com.example.libreria.repository;

import com.example.libreria.model.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
}

