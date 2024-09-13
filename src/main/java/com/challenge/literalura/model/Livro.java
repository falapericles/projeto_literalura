package com.challenge.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name="livros")
public class Livro {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(unique=true)
        private String titulo;
        private String idioma;
        private String autor;
        private Integer qtdDeDownload;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getQtdDeDownload() {
        return qtdDeDownload;
    }

    public void setQtdDeDownload(Integer qtdDeDownload) {
        this.qtdDeDownload = qtdDeDownload;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\''+
                ", idioma=" + idioma +
                ", autor='" + autor +'}';
    }
}
