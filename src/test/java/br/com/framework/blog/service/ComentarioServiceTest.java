package br.com.framework.blog.service;

import br.com.framework.blog.model.Autor;
import br.com.framework.blog.model.Comentario;
import br.com.framework.blog.model.Postagem;
import br.com.framework.blog.repository.AutorRepository;
import br.com.framework.blog.repository.ComentarioRepository;
import br.com.framework.blog.repository.PostagemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SpringBootTest
class ComentarioServiceTest {

    @Mock
    ComentarioRepository comentarioRepository;
    @Mock
    PostagemRepository postagemRepository;
    @Mock
    AutorRepository autorRepository;


    @InjectMocks
    ComentarioService comentarioService;


    @Test
    void whenAddNewComents_ReturnSuccess() {
        Postagem postagem = new Postagem();
        Autor autor = new Autor();
        Comentario comentario = new Comentario();
        List<Comentario> comentarios = new ArrayList<>();
        when(postagemRepository.findById(anyInt())).thenReturn(postagem);
        when(autorRepository.findById(anyInt())).thenReturn(autor);
        when(comentarioRepository.findByPostagemId(anyInt())).thenReturn(comentarios);
        when(comentarioRepository.save(comentario)).thenReturn(comentario);
        when(postagemRepository.save(postagem)).thenReturn(postagem);
        comentario.setComentario("Testess");
        comentario.setAutor(autor);
        comentario.setPostagem(postagem);
        comentarios.add(comentario);
        postagem.setComentarios(comentarios);
        postagem.setDataAtualizacao(LocalDate.now());
        postagem.setComentarios(comentarios);
        Assertions.assertNotNull(postagem.getComentarios());
    }

    @Test
    void whenUpdateComentsInPost_ReturnSuccess(){
        Postagem postagem = new Postagem();
        Comentario comentario = new Comentario();
        String updateComentatio = "Atualizado comentário";
        List<Comentario> comentarios = new ArrayList<>();
        when(postagemRepository.findById(anyInt())).thenReturn(postagem);
        when(comentarioRepository.findById(anyInt())).thenReturn(comentario);
        comentario.setComentario(updateComentatio);
        postagem.setDataAtualizacao(LocalDate.now());
        when(comentarioRepository.save(comentario)).thenReturn(comentario);
        when(postagemRepository.save(postagem)).thenReturn(postagem);
        Assertions.assertNotNull(postagem.getComentarios());
    }



}