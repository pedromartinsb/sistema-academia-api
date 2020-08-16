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
@Table( name = "plano_treino" , schema = "academias")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanoTreino {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_exercicio")
    private Exercicio exercicio;

    @ManyToOne
    @JoinColumn(name = "id_treino")
    private Treino treino;

    @Column(name = "repeticoes")
    private Integer repeticoes;

    @Column(name = "carga")
    private Integer carga;

    @Column(name = "series")
    private Integer series;

}
