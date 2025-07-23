package com.example.libreria.mapper;

import com.example.libreria.DTO.RecensioneDTO;
import com.example.libreria.model.Libro;
import com.example.libreria.model.Recensione;
import com.example.libreria.model.Utente;

public class RecensioneMapper {

    
       public static RecensioneDTO toDTO(Recensione recensione) {
        return RecensioneDTO.builder()
                .id(recensione.getId())
                .descrizione(recensione.getDescrizione())
                .utenteId(recensione.getUtente().getId())
                .libroId(recensione.getLibro().getId())
                .build();
    }

    public static Recensione toEntity(RecensioneDTO dto, Utente utente, Libro libro) {
        return Recensione.builder()
                .id(dto.getId())
                .descrizione(dto.getDescrizione())
                .utente(utente)
                .libro(libro)
                .build();
    }
    
}
