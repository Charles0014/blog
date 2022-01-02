package br.com.framework.blog.repository;

import br.com.framework.blog.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    Postagem findById(long id);

}
