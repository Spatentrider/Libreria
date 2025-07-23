package com.example.libreria.DTO;

import java.util.List;

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
public class AutoreDTO {
     
    private Long id;
    private String name;
    private List<LibroDTO> libriDTO;
}
