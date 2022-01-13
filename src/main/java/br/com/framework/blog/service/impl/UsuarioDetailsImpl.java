package br.com.framework.blog.service.impl;

import br.com.framework.blog.data.UsuarioDetails;
import br.com.framework.blog.model.Usuario;
import br.com.framework.blog.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioDetailsImpl implements UserDetailsService {
    private final UsuarioRepository repository;

    public UsuarioDetailsImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByLogin(username);
        if (username.isEmpty()) {
            throw new UsernameNotFoundException("Usuário  [" + username + "]  não encontrado");
        }
        return new UsuarioDetails(usuario);
    }
}
