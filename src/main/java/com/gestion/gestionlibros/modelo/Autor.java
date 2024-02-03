package com.gestion.gestionlibros.modelo;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Entity
@Scope("prototype")
public class Autor {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_ID_AUTOR")
    @SequenceGenerator(name = "SECUENCIA_ID_AUTOR", sequenceName = "GENERADOR_ID_AUTOR", allocationSize = 1)
    @Id
    private long idAutor;
    private String nombre;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Libro> libros = new ArrayList<>();

    public Autor() {
    }

    public Autor(long idAutor, String nombre) {
        this.idAutor = idAutor;
        this.nombre = nombre;
    }

    public long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }


    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
