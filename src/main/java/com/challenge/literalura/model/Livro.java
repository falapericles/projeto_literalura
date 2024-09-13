package com.challenge.literalura.model;

import jakarta.persistence.*;
import java.util.Collections;

@Entity
@Table(name="livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String idioma;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
    @Column(name = "autor_nome")
    private String autorNome;
    private Integer qtdDeDownload;

    public Livro() {
    }
    public Livro(DadoLivro dadoLivro) {
        this.titulo = dadoLivro.titulo();
        if (!dadoLivro.autor().isEmpty()) {
            DadoAutor primeiroAutor = dadoLivro.autor().get(0);
            this.autor = new Autor(primeiroAutor.nome(), primeiroAutor.anoNascimento(), primeiroAutor.anoMorte());
            this.autorNome = autor.getNome();
        }
        this.idioma = String.valueOf(dadoLivro.idioma());
        this.qtdDeDownload = dadoLivro.qtdDeDownload();
    }

    public Long getId() {
        return id;
    }

    public String getAutorNome() {
        return autorNome;
    }

    public void setAutorNome(String autorNome) {
        this.autorNome = autorNome;
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
        this.idioma = String.valueOf(Collections.singletonList(idioma));
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
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
                ", idioma=" + idioma + ", autor='"+autorNome +'}';
    }
}
