package br.com.evaldo91.forumhub.controller;

import br.com.evaldo91.forumhub.domain.resposta.CriarResposta;
import br.com.evaldo91.forumhub.domain.resposta.RespostaDTO;
import br.com.evaldo91.forumhub.domain.resposta.RespostaRepository;
import br.com.evaldo91.forumhub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topico")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private CriarTopico criar;

    @Autowired
    private CriarResposta resposta;
    @Autowired
    private  Topico topico;


    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody @Valid CriarTopicoDTO dados) {
        var dto = criar.novoTopico(dados);
        return ResponseEntity.ok(dto);
    }


    @PostMapping("/responder")
    @Transactional
    public ResponseEntity responder(@RequestBody @Valid RespostaDTO dados) {
        var dto = resposta.respondendo(dados);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid AtulizarTopicoDTO dados){
        var topico = repository.getReferenceById(dados.id());
       topico.novo(dados);
        return  ResponseEntity.ok(new DetalhamentoTopico(topico));
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



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
       repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
