package com.daniel.sistemaacademia.model.dto;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExercicioDTO {

    private String nome;
    private String dica;
    private String grupoMuscular;
    private String repeticoes;
    private String carga;
    private String series;
}
