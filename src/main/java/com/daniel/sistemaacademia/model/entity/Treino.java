package com.daniel.sistemaacademia.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table( name = "treino" , schema = "academias")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treino {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_modalidade")
    private Modalidade modalidade;

    @Column(name = "tipo_treino")
    private String tipoTreino;

    @Column(name = "nome_treino")
    private String nomeTreino;

}
