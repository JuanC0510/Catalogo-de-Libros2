package com.catalogoApp.Catalogo.de.Libros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(

        @JsonAlias("id") String id,
        @JsonAlias("title") Integer title,
        @JsonAlias("authors") List<DatosAutor> autores,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Integer download

) {
}
