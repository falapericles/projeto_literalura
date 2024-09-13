package com.challenge.literalura.service;

import com.challenge.literalura.model.DadoLivro;

import java.util.List;

public record LivroResposta(
        int count,
        String next,
        String previous,
        List<DadoLivro> results
) {}