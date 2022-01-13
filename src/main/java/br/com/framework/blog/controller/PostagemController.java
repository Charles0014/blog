package br.com.framework.blog.controller;

import br.com.framework.blog.model.Postagem;
import br.com.framework.blog.repository.PostagemRepository;
import br.com.framework.blog.service.PostagemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/blog/postagem")
@CrossOrigin(origins = "*")
@Slf4j
public class PostagemController {

    private final PostagemRepository postagemRepository;
    private final PostagemService postagemService;


    public PostagemController(PostagemRepository repository, PostagemService service) {
        this.postagemRepository = repository;
        this.postagemService = service;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Postagem>> findAll() {
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Postagem> findById(@PathVariable(value = "id") long id) {
        return ResponseEntity.ok(postagemService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Postagem> save(@RequestBody Postagem postagem) {
        return ResponseEntity.ok(postagemRepository.save(postagem));
    }

    @PutMapping("/update")
    public ResponseEntity<Postagem> update(@RequestBody Postagem postagem) {
        postagem.setDataAtualizacao(LocalDate.now());
        return ResponseEntity.ok(postagemRepository.save(postagem));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<List<Postagem>> delete(@RequestBody Postagem postagem) {
        return ResponseEntity.ok(postagemService.delete(postagem));
    }

}
