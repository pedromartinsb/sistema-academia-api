package com.daniel.sistemaacademia.repository;

import com.daniel.sistemaacademia.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
