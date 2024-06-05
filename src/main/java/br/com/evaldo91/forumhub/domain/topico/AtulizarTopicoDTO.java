package br.com.evaldo91.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtulizarTopicoDTO(
        @NotBlank
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem
  ) {

}
