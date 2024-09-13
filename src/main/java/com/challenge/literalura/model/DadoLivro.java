package com.challenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadoLivro(@JsonAlias("title") String titulo,
                        @JsonAlias("languages") String idioma,
                        @JsonAlias("authors") String autor,
                        @JsonAlias("download_count") Integer qtdDeDownload) {
}
