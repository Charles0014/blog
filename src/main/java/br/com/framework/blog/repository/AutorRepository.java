package br.com.framework.blog.repository;

import br.com.framework.blog.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findById(long id);

}
