package br.com.framework.blog.controller;

import br.com.framework.blog.model.Usuario;
import br.com.framework.blog.repository.UsuarioRepository;
import br.com.framework.blog.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/usuario")
@CrossOrigin(origins = "*")
@Slf4j
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioService usuarioService;

    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioService usuarioService, PasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
        this.encoder = encoder;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @GetMapping("/valid")
    public ResponseEntity<Boolean> validPassword(@RequestParam String login, @RequestParam String password) {
        try {
            return usuarioService.validPassword(login, password);
        } catch (Exception e) {
            log.info("", e);
            return null;
        }

    }

}
