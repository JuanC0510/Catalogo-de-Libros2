package com.catalogoApp.Catalogo.de.Libros.longitud;

public class Longitud {
    public static String limitarLongitud(String longitud, int longitudMaxima) {
        if (longitud.length() <= longitudMaxima) {
            return longitud;
        } else {
            return longitud.substring(0,longitudMaxima);
        }
    }
}
