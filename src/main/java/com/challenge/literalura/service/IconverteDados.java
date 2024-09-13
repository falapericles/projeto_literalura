package com.challenge.literalura.service;

public interface IconverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
