package com.catalogoApp.Catalogo.de.Libros.repository;

import com.catalogoApp.Catalogo.de.Libros.model.LibroDelAutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository  extends JpaRepository<LibroDelAutor, Long> {
    @Query("SELECT 1  FROM LibroDelAutor 1 WHERE 1.lenguaje >= :idioma")
    List<LibroDelAutor> findForLanguaje(String idioma);
}
