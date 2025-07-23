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
public class UtenteDTO {
    
    private Long id;
    private String nome;
    private List<RecensioneDTO> recensioniDTO;
    
}
