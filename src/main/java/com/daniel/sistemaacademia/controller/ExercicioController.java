package com.daniel.sistemaacademia.controller;

import com.daniel.sistemaacademia.exception.RegraNegocioException;
import com.daniel.sistemaacademia.model.dto.ExercicioDTO;
import com.daniel.sistemaacademia.model.entity.Exercicio;
import com.daniel.sistemaacademia.repository.ExercicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercicios")
@RequiredArgsConstructor
public class ExercicioController {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @GetMapping
    public ResponseEntity findAll() {
        List<Exercicio> exercicios = exercicioRepository.findAll();
        return ResponseEntity.ok(exercicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<Exercicio> exercicio = exercicioRepository.findById(id);
        if(exercicio.isPresent()) {
            return ResponseEntity.ok(exercicio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ExercicioDTO dto) {
        try {
            Exercicio entidade = new Exercicio().converter(dto);
            entidade = exercicioRepository.save(entidade);
            return new ResponseEntity(entidade, HttpStatus.CREATED);
        }catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable("id") Long id, @RequestBody ExercicioDTO dto) {
        Optional<Exercicio> exercicio = exercicioRepository.findById(id);
        if(exercicio.isPresent()) {
            Exercicio exercicioConvertido = new Exercicio().converter(dto);
            exercicioRepository.save(exercicioConvertido);
            return ResponseEntity.ok(exercicioConvertido);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Exercicio> exercicio = exercicioRepository.findById(id);
        if(exercicio.isPresent()) {
            exercicioRepository.delete(exercicio.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().body("Exercicio não encontrado.");
        }
    }

}
