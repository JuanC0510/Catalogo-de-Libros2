package com.catalogoApp.Catalogo.de.Libros.service;

public interface lConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);
}
