package br.com.framework.blog.service;

import br.com.framework.blog.model.Usuario;
import br.com.framework.blog.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioServiceTest {


    @Mock
    UsuarioRepository usuarioRepository;

    @Mock
    PasswordEncoder encoder;

    @InjectMocks
    UsuarioService usuarioService;

    @Test
    void whenUserIsValid_ReturnSuccess(){
        Usuario usuario = new Usuario();
        when(usuarioRepository.findByLogin(anyString())).thenReturn(Optional.of(usuario));
        when(encoder.matches(anyString(), anyString())).thenReturn(true);
    }

}