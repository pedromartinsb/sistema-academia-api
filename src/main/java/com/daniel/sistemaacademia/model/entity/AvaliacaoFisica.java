package com.daniel.sistemaacademia.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table( name = "avaliacao_fisica" , schema = "academias")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisica {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_desempenho")
    private Desempenho desempenho;

    @Column(name = "avaliador")
    private String avaliador;

    @Column(name = "data_avaliacao")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataAvaliacao;

}
