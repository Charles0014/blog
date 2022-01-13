package br.com.framework.blog.service;

import br.com.framework.blog.model.Autor;
import br.com.framework.blog.model.Postagem;
import br.com.framework.blog.repository.PostagemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class PostagemServiceTest {

    @Mock
    PostagemRepository postagemRepository;

    @InjectMocks
    PostagemService postagemService;


    @Test
    void whenUserEqualsUserPost__ReturnSuccess(){
        List<Postagem> postagems = new ArrayList<>();
        Autor autor = new Autor();
        Postagem postagem = new Postagem();
        postagem.setId(12L);
        postagem.setAutor(autor);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        postagems.add(postagem);
        when(postagemService.delete(postagem)).thenReturn(postagems);
        assertNotNull(postagemService.delete(postagem));
    }

    @Test
    void whenUserDifferentUserPost_ReturnException(){
        Autor autor = new Autor();
        Postagem postagem = new Postagem();
        postagem.setId(12L);
        postagem.setAutor(autor);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(postagemService.delete(postagem)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,() -> postagemService.delete(postagem));
    }


}