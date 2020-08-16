package com.daniel.sistemaacademia.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "usuario" , schema = "academias")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	@Id
	@Column(name = "id")
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	@JsonIgnore
	private String senha;

}
