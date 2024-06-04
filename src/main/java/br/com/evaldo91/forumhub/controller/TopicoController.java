package br.com.evaldo91.forumhub.controller;

import br.com.evaldo91.forumhub.domain.resposta.CriarResposta;
import br.com.evaldo91.forumhub.domain.resposta.RespostaDTO;
import br.com.evaldo91.forumhub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping
    public ResponseEntity<Page<ListagemTopicoDTO>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(ListagemTopicoDTO::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoTopico(topico));
    }

}
