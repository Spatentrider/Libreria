package com.example.libreria.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroDTO {
    
    private Long id;
    private String titolo;
    private Double prezzo;
    private List<RecensioneDTO> recensioni;
    private Long autoreId;
}
