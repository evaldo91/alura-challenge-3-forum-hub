package br.com.evaldo91.forumhub.controller;

import br.com.evaldo91.forumhub.domain.resposta.CriarResposta;
import br.com.evaldo91.forumhub.domain.resposta.RespostaDTO;
import br.com.evaldo91.forumhub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topico")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private CriarTopico criar;

    @Autowired
    private CriarResposta resposta;

    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody @Valid CriarTopicoDTO dados) {
        var dto = criar.novoTopico(dados);
        return ResponseEntity.ok(dto);
    }


    @PostMapping("/responder")
    @Transactional
    public ResponseEntity novaResposta(@RequestBody @Valid RespostaDTO dados) {
        var dto = resposta.novaResposta(dados);
        return ResponseEntity.ok(dto);
    }
}
