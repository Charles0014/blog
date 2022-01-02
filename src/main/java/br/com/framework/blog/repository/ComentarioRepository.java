package br.com.framework.blog.repository;

import br.com.framework.blog.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    Comentario findById(long id);
    List<Comentario> findByPostagemId(long id);
}
