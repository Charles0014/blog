package br.com.framework.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_COMENTARIO")
@Data
public class Comentario {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @NotBlank
    private Autor autor;

    @NotBlank
    private String comentario;

    @JsonIgnore
    @JoinColumn(name = "postagem_id")
    @ManyToOne
    private Postagem postagem;

}
