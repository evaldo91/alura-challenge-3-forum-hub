package br.com.evaldo91.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarTopicoDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        Long idUsuario,
        @NotNull
        Long idCurso

) {



}
