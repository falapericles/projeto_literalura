package com.challenge.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String nome;
    private Integer anoNascimento;
    private Integer anoMorte;
}
