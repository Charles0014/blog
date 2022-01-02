package br.com.framework.blog.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
@Data
public class Usuario {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String login;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


}
