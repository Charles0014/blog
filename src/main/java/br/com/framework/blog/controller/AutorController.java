package br.com.framework.blog.controller;

import br.com.framework.blog.model.Autor;
import br.com.framework.blog.repository.AutorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog/autor/")
@CrossOrigin(origins = "*")
@Slf4j
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<Autor> save(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorRepository.save(autor));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> findAll() {
        return ResponseEntity.ok(autorRepository.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Autor> findById(@PathVariable(value = "id") long id) {
        return ResponseEntity.ok(autorRepository.findById(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Autor>> delete(@RequestBody Autor autor) {
        try {
            autorRepository.delete(autor);
            log.info("Apagado com sucesso");
        } catch (Exception e) {
            log.info("Não pode ser apagado -- está vinculado a publicação");
        }
        return ResponseEntity.ok(autorRepository.findAll());
    }

    @PutMapping("/update")
    public ResponseEntity<Autor> update(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorRepository.save(autor));
    }


}
