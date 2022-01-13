package br.com.framework.blog.service;

import br.com.framework.blog.model.Autor;
import br.com.framework.blog.model.Comentario;
import br.com.framework.blog.model.Postagem;
import br.com.framework.blog.repository.AutorRepository;
import br.com.framework.blog.repository.ComentarioRepository;
import br.com.framework.blog.repository.PostagemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    private final PostagemRepository postagemRepository;

    private final AutorRepository autorRepository;

    public ComentarioService(ComentarioRepository comentarioRepository, PostagemRepository postagemRepository, AutorRepository autorRepository) {
        this.comentarioRepository = comentarioRepository;
        this.postagemRepository = postagemRepository;
        this.autorRepository = autorRepository;
    }

    public Postagem newComentario(long idPostagem, long idAutor, String comentatio) {
        try {
            Postagem postagem = postagemRepository.findById(idPostagem);
            Autor autor = autorRepository.findById(idAutor);
            List<Comentario> comentarios = comentarioRepository.findByPostagemId(postagem.getId());
            Comentario comentario = new Comentario();
            comentario.setComentario(comentatio);
            comentario.setAutor(autor);
            comentario.setPostagem(postagem);
            comentarios.add(comentario);
            comentarioRepository.save(comentario);
            postagem.setComentarios(comentarios);
            postagem.setDataAtualizacao(LocalDate.now());
            postagem.setComentarios(comentarios);
            return postagemRepository.save(postagem);
        } catch (Exception e) {
            log.warn("Erro no processo" + e);
        }
        return null;
    }


    public Postagem updateComentario(long idPostagem, long idComentario, String updateComentatio) {
        Postagem postagem = postagemRepository.findById(idPostagem);
        Comentario comentario = comentarioRepository.findById(idComentario);
        comentario.setComentario(updateComentatio);
        postagem.setDataAtualizacao(LocalDate.now());
        comentarioRepository.save(comentario);
        return postagemRepository.save(postagem);
    }

    public Postagem deleteComentario(long idPostagem, long idComentario) {
        try {
            Postagem postagem = postagemRepository.findById(idPostagem);
            Comentario comentario = comentarioRepository.findById(idComentario);
            comentarioRepository.delete(comentario);
            postagem.setDataAtualizacao(LocalDate.now());
            log.info("Apagado com sucesso");
            return postagemRepository.save(postagem);

        } catch (Exception e) {
            log.info("Não foi possível apagar comentário ");
            return null;
        }

    }
}
