package com.challenge.literalura.repository;

import com.challenge.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    boolean existsByTitulo(String titulo);
    List<Livro> findByTituloContainingIgnoreCase(String titulo);
    int countByIdiomaContainingIgnoreCase(String sigla);
}
