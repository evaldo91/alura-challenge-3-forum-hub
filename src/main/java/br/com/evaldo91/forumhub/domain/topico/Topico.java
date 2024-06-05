package br.com.evaldo91.forumhub.domain.topico;

import br.com.evaldo91.forumhub.domain.curso.Curso;
import br.com.evaldo91.forumhub.domain.usuario.Usuario;
import br.com.evaldo91.forumhub.domain.resposta.Resposta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, String status, Usuario usuario, Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.usuario = usuario;
        this.curso = curso;
    }
    @Autowired
    private TopicoRepository repository;

    public void atualizarStatus() {
        this.status = "respondido";
    }

    public void novo(AtulizarTopicoDTO dados) {
        if (dados.titulo()  !=null){
            this.titulo = dados.titulo();
        }
         if(dados.mensagem() !=null){
            this.mensagem = dados.mensagem();;
        }


    }
}
