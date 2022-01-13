package br.com.framework.blog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_POSTAGEM")
@Data
public class Postagem {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @NotBlank
    private Autor autor;

    private LocalDate dataCriacao = LocalDate.now();

    private LocalDate dataAtualizacao;

//    @Lob
//    @Type(type = "org.hibernate.type.ImageType")
//    private byte[] imagem;

    @Column(name = "c_text", columnDefinition = "TEXT")
    private String conteudo;

    @OrderBy("data_criacao")
    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

}
