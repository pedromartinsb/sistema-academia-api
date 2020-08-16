package com.daniel.sistemaacademia.controller;

import com.daniel.sistemaacademia.model.dto.AlunoDTO;
import com.daniel.sistemaacademia.exception.RegraNegocioException;
import com.daniel.sistemaacademia.model.entity.Aluno;
import com.daniel.sistemaacademia.model.entity.Usuario;
import com.daniel.sistemaacademia.repository.AlunoRepository;
import com.daniel.sistemaacademia.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos/")
@RequiredArgsConstructor
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity findAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        // checando se o aluno com o id está na base de dados
        if(aluno.isPresent()) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.badRequest().body("Usuário não encontrado.");
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AlunoDTO dto) {
        try {
            Aluno entidade = converter(dto);
            entidade = alunoRepository.save(entidade);
            return new ResponseEntity(entidade, HttpStatus.CREATED);
        }catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@PathVariable("id") Long id, @RequestBody AlunoDTO dto) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(aluno.isPresent()) {
            Aluno alunoConvertido = converter(dto);
            return ResponseEntity.ok(alunoConvertido);
        }

        return ResponseEntity.notFound().build();
    }

    private Aluno converter(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setCpf(dto.getCpf());
        aluno.setRg(dto.getRg());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setEndereco(dto.getEndereco());
        aluno.setBairro(dto.getBairro());
        aluno.setCep(dto.getCep());
        aluno.setCidade(dto.getCidade());
        aluno.setUf(dto.getUf());
        aluno.setObjetivo(dto.getObjetivo());
        aluno.setMatriculado(dto.isMatriculado());
        aluno.setEstadoCivil(dto.getEstadoCivil());
        aluno.setProfissao(dto.getProfissao());
        aluno.setIdade(dto.getIdade());
        aluno.setDebito(dto.getDebito());
        aluno.setDataCadastro(dto.getDataCadastro());

        Optional<Usuario> usuarioRetorno = this.usuarioRepository.findById(dto.getUsuario());
        if (usuarioRetorno.isPresent()) {
            aluno.setUsuario(usuarioRetorno.get());
        }

        return aluno;
    }
}
