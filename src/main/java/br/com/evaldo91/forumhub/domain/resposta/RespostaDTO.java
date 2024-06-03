package br.com.evaldo91.forumhub.domain.resposta;

import java.time.LocalDateTime;

public record RespostaDTO(
        Long idTopico,
        Long idUsuario,
        String mensagem,
        LocalDateTime data

) {
}
