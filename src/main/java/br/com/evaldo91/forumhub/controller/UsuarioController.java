package br.com.evaldo91.forumhub.controller;

import br.com.evaldo91.forumhub.domain.usuario.CadastroUsuario;
import br.com.evaldo91.forumhub.domain.usuario.DadosDetalhamentoUsuario;
import br.com.evaldo91.forumhub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import br.com.evaldo91.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostMapping("/novo")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(dados);

        usuario.setPassword(passwordEncoder.encode(dados.senha()));

        repository.save(usuario);

        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }


}
