package br.com.evaldo91.forumhub.domain.usuario;

public record CadastroUsuario(
        String nome,
        String email,
        String senha,
        String perfil
) {
}
