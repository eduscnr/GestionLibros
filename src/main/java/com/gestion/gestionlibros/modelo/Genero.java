package com.gestion.gestionlibros.modelo;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Entity
@Scope("prototype")
public class Genero {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_ID_GENERO")
    @SequenceGenerator(name = "SECUENCIA_ID_GENERO", sequenceName = "GENERADOR_ID_GENERO", allocationSize = 1)
    @Id
    private long idGenero;
    private String tipo;
    @OneToMany(mappedBy = "genero", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Libro> libros = new ArrayList<>();

    public Genero() {
    }

    public Genero(long idGenero, String tipo) {
        this.idGenero = idGenero;
        this.tipo = tipo;
    }

    public long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(long idGenero) {
        this.idGenero = idGenero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
