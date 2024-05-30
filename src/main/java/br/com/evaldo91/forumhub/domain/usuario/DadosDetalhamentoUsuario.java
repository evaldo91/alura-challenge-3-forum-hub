package br.com.evaldo91.forumhub.domain.usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String email,String perfis
) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPerfil());
    }
}
