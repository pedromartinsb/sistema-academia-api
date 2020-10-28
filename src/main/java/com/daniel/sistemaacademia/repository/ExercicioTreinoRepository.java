package com.daniel.sistemaacademia.repository;

import com.daniel.sistemaacademia.model.entity.ExercicioTreino;
import com.daniel.sistemaacademia.model.entity.GrupoMuscular;
import com.daniel.sistemaacademia.model.entity.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExercicioTreinoRepository extends JpaRepository<ExercicioTreino, Long> {

    List<ExercicioTreino> findAllByTreino(Treino treino);
}
