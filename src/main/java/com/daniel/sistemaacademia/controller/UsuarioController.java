package com.daniel.sistemaacademia.controller;

import java.util.Optional;

import com.daniel.sistemaacademia.exception.ErroAutenticacao;
import com.daniel.sistemaacademia.model.entity.Usuario;
import com.daniel.sistemaacademia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.sistemaacademia.model.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody UsuarioDTO dto) {
		try {
			Optional<Usuario> usuarioRetorno = usuarioRepository.findByEmail(dto.getEmail());

			// checando se o usuario esta cadastrado no banco de dados
			if (usuarioRetorno.isPresent()) {

				// checando se as senhas são iguais
				if(usuarioRetorno.get().getSenha().equals(dto.getSenha())) {
					return ResponseEntity.ok(usuarioRetorno.get());
				} else {
					return ResponseEntity.badRequest().body("Senha incorreta para o email informado.");
				}

			} else {
				return ResponseEntity.badRequest().body("Usuário com o email informado não cadastrado no banco de dados.");
			}

		} catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
