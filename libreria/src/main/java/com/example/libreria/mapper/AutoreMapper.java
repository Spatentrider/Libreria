package com.example.libreria.mapper;

import java.util.List;

import com.example.libreria.DTO.AutoreDTO;
import com.example.libreria.model.Autore;
import com.example.libreria.model.Libro;

public class AutoreMapper{ 
    // toEntity
    public static Autore toEntity(AutoreDTO dto, List<Libro> libri) {
        return Autore.builder()
                .id(dto.getId())
                .name(dto.getName())
                .libri(libri)
                .build();
    }

    // toDTO
    public static AutoreDTO toDTO(Autore autore) {
        return AutoreDTO.builder()
                .id(autore.getId())
                .name(autore.getName())
                .libriDTO(autore.getLibri().stream()
                        .map(LibroMapper::toDTO)
                        .toList())
                .build();
    }
}