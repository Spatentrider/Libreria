package com.example.libreria.mapper;

import java.util.List;

import com.example.libreria.DTO.LibroDTO;
import com.example.libreria.model.Autore;
import com.example.libreria.model.Libro;
import com.example.libreria.model.Recensione;


public class LibroMapper {

       public static LibroDTO toDTO(Libro libro) {
        return LibroDTO.builder()
                .id(libro.getId())
                .titolo(libro.getTitolo())
                .prezzo(libro.getPrezzo())
                .recensioni(libro.getRecensioni().stream().map(RecensioneMapper::toDTO).toList())
                .autoreId(libro.getAutore().getId())
                .build();
    }

    public static Libro toEntity(LibroDTO dto, List<Recensione> recensioni, Autore autore) {
        return Libro.builder()
                .id(dto.getId())
                .titolo(dto.getTitolo())
                .prezzo(dto.getPrezzo())
                .recensioni(recensioni)
                .autore(autore)
                .build();
    }

    
}
