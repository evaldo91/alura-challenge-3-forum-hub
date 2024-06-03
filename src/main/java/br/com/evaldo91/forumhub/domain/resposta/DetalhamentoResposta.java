package br.com.evaldo91.forumhub.domain.resposta;

import java.time.LocalDateTime;

public record DetalhamentoResposta(
        String topico,
        String mensagem,
        String usuario,
        LocalDateTime data
) {
    public DetalhamentoResposta(Resposta resposta){
        this(resposta.getTopico().getTitulo(), resposta.getMensagem(), resposta.getUsuario().getNome(),
                resposta.getDataCriacao());
    }
}
