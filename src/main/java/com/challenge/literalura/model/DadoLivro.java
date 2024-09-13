package com.challenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadoLivro(@JsonAlias("title") String titulo,
                        @JsonAlias("languages") List<String> idioma,
                        @JsonAlias("authors") List<DadoAutor> autor,
                        @JsonAlias("download_count") Integer qtdDeDownload) {
}
