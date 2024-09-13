package com.challenge.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadoAutor(@JsonAlias("name") String nome,
                           @JsonAlias("birth_year") Integer anoNascimente,
                           @JsonAlias("death_year") Integer anoMorte) {
}
