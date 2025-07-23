package com.example.libreria.mapper;

import java.util.List;

import com.example.libreria.DTO.UtenteDTO;
import com.example.libreria.model.Recensione;
import com.example.libreria.model.Utente;

public class UtenteMapper {

        
       public static UtenteDTO toDTO(Utente utente) {
        return UtenteDTO.builder()
                .id(utente.getId())
                .nome(utente.getNome())
                .recensioniDTO(
                 utente.getRecensioni().stream()
                 .map(RecensioneMapper::toDTO)
                 .toList()
                )
                .build();
    }

    public static Utente toEntity(UtenteDTO dto, List<Recensione> recensioni) {
        return Utente.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .recensioni(recensioni)
                .build();
    }
    
}
