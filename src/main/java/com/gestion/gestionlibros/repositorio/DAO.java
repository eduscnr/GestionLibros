package com.gestion.gestionlibros.repositorio;

import com.gestion.gestionlibros.modelo.Cliente;
import com.gestion.gestionlibros.modelo.Libro;

import java.util.List;

public interface DAO {
    public List<Libro> listarLibros();
    public Libro obtenerLibroPorId(long idLib);
    public boolean agregarCliente(Cliente cliente);
    public Cliente buscarCliente(Cliente cliente);
}
