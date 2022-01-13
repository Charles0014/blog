package br.com.framework.blog.service;


import br.com.framework.blog.model.Postagem;
import br.com.framework.blog.repository.PostagemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Slf4j
public class PostagemService {

    private final PostagemRepository postagemRepository;

    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public Postagem findById(@PathVariable(value = "id") long id) {
        return postagemRepository.findById(id);

    }

    public List<Postagem> delete(Postagem postagem) {
        postagemRepository.delete(postagem);
        log.info("Apagado com sucesso");
        return postagemRepository.findAll();
    }

}
