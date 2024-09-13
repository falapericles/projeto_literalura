package com.challenge.literalura.repository;

import com.challenge.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.nome = :nome")
    Optional<Autor> findByNome(String nome);

    @Query("Select a from Autor a where a.anoNascimento<= :ano and a.anoMorte>= :ano")
    List<Autor> encontreOsVivos(@Param("ano") Integer ano);
}
