package br.com.evaldo91.forumhub.controller;

import br.com.evaldo91.forumhub.domain.topico.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

public record ListagemTopicoDTO(      Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String Usuario,
        String curso

){

public ListagemTopicoDTO(Topico topico) {
    this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
            topico.getDataCriacao(), topico.getStatus(), topico.getUsuario().getNome(), topico.getCurso().getNome());
}
}