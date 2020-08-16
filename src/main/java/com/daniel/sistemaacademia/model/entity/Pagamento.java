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
@Table( name = "pagamento" , schema = "academias")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_matricula")
    private Matricula matricula;

    @Column(name = "valor_pago")
    private BigDecimal valorPago;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Column(name = "data_pagamento")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate dataPagamento;

    @Column(name = "forma_pagamento")
    private String formaPagamento;

}
