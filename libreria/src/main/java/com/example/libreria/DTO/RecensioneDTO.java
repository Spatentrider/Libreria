package com.example.libreria.DTO;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecensioneDTO {
    private Long id;
    private String descrizione;
    private Long utenteId;
    private Long libroId;
}
