package com.catalogoApp.Catalogo.de.Libros.repository;

import com.catalogoApp.Catalogo.de.Libros.model.AutorDelLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<AutorDelLibro, Long> {
    @Query("SELECT a FROM AutorDelLibro a WHERE :año between a.fechaDeNacimiento AND a.fechaDeFallecimiento")
    List<AutorDelLibro> findForYear(int año);
}
