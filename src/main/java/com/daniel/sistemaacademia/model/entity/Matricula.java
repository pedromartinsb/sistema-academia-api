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
@Table( name = "matricula" , schema = "academias")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {

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

    @Column(name = "data_matricula")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataMatricula;

    @Column(name = "desconto")
    private BigDecimal desconto;

    @Column(name = "data_vencimento")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataVencimento;

    @Column(name = "valor_final")
    private BigDecimal valorFinal;

    @Column(name = "data_fim")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataFim;

}
