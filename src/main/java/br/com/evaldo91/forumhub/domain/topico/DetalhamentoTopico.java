package br.com.evaldo91.forumhub.domain.topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DetalhamentoTopico (
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String Usuario,
        String curso

){

    public DetalhamentoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),
                topico.getDataCriacao(), topico.getStatus(), topico.getUsuario().getNome(), topico.getCurso().getNome());
    }
    }
