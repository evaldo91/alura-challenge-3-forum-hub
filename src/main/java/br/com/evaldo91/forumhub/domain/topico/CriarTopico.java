package br.com.evaldo91.forumhub.domain.topico;

import br.com.evaldo91.forumhub.domain.curso.CursoRepository;
import br.com.evaldo91.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarTopico {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public  DetalhamentoTopico novoTopico(CriarTopicoDTO dados) {



        var data = LocalDateTime.now();
        var status = "nao respondido";
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var curso = cursoRepository.getReferenceById(dados.idCurso());




        var topico = new Topico(null, dados.titulo(), dados.mensagem(), data, status, usuario, curso);

        topicoRepository.save(topico);
        return new DetalhamentoTopico(topico);





    }
}
