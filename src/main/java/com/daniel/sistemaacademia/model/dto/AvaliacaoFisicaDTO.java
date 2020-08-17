package com.daniel.sistemaacademia.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaDTO {

    private Long aluno;
    private Long desempenho;
    private String avaliador;
    private LocalDate dataAvaliacao;

}
