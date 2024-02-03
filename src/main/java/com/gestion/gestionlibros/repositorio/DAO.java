package com.gestion.gestionlibros.repositorio;

import com.gestion.gestionlibros.modelo.Libro;

import java.util.List;

public interface DAO {
    public List<Libro> listarLibros();
    public Libro obtenerLibroPorId(long idLib);
}
