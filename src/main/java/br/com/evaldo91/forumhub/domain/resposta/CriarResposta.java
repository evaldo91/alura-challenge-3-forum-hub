package br.com.evaldo91.forumhub.domain.resposta;

import br.com.evaldo91.forumhub.domain.topico.TopicoRepository;
import br.com.evaldo91.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CriarResposta {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespostaRepository respostaRepository;

    public DetalhamentoResposta novaResposta(RespostaDTO dados) {

        var data = LocalDateTime.now();
        var usuario = usuarioRepository.getReferenceById(dados.idUsuario());
        var topico = topicoRepository.getReferenceById(dados.idTopico());
        topico.atualizarStatus();
        var resposta = new Resposta(null, dados.mensagem(), data, usuario, topico);

        respostaRepository.save(resposta);
        return new DetalhamentoResposta(resposta);
    }
}
