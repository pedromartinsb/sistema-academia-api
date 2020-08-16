package com.daniel.sistemaacademia.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name = "exercicio" , schema = "academias")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercicio {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "grupo_muscular")
    private String grupoMuscular;

}
