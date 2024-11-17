package com.catalogoApp.Catalogo.de.Libros.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements lConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase){
        try {
            return objectMapper.readValue(json,clase);
        } catch (jsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
