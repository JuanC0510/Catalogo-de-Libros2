package com.catalogoApp.Catalogo.de.Libros.model;

import com.catalogoApp.Catalogo.de.Libros.longitud.Longitud;
import jakarta.persistence.*;

@Entity
@Table(name = "Autor")
public class AutorDelLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaDeFallecimiento;

    @OneToOne
    @JoinTable(
            name = "Libro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private AutorDelLibro libros;

    public AutorDelLibro() {

    }

    public AutorDelLibro(DatosAutor autor) {
        this.nombre = Longitud.limitarLongitud(autor.name(), 200);

        if (autor.birthYear() == null)
            this.fechaDeNacimiento = 1980;

        else
            this.fechaDeNacimiento = autor.birthYear();

        if (autor.deathYear() == null)
            this.fechaDeFallecimiento = 3022;
        else
            this.fechaDeFallecimiento = autor.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(Integer fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }

    @Override
    public String toString() {
        return "AutorLibro id=" + id +
                ", nombre=" + nombre +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", fechaDeFallecimiento=" + fechaDeFallecimiento +
                ", libro=";
    }

    public AutorDelLibro getLibros() {
        return libros;
    }

    public void setLibros(AutorDelLibro libros) {
        this.libros = libros;
    }
}
