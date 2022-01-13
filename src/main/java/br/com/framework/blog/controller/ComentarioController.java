package br.com.framework.blog.controller;

import br.com.framework.blog.model.Postagem;
import br.com.framework.blog.service.ComentarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog/comentario/")
@CrossOrigin(origins = "*")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping("save/{idPost}/{idAutor}")
    public ResponseEntity<Postagem> save(@PathVariable(value = "idPost") long idPost, @PathVariable(value = "idAutor") long idAutor, @RequestBody String comentario) {
        return ResponseEntity.ok(comentarioService.newComentario(idPost, idAutor, comentario));
    }

    @PutMapping("update/{idPost}/{idComentario}")
    public ResponseEntity<Postagem> update(@PathVariable(value = "idPost") long idPost, @PathVariable(value = "idComentario") long idComentario, @RequestBody String updateComentatio) {
        return ResponseEntity.ok(comentarioService.updateComentario(idPost, idComentario, updateComentatio));
    }

    @DeleteMapping("delete/{idPost}/{idComentario}")
    public ResponseEntity<Postagem> delete(@PathVariable(value = "idPost") long idPost, @PathVariable(value = "idComentario") long idComentario) {
        return ResponseEntity.ok(comentarioService.deleteComentario(idPost, idComentario));
    }

}
