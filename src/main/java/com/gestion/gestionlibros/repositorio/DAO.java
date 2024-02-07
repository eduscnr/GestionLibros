package com.gestion.gestionlibros.repositorio;

import com.gestion.gestionlibros.modelo.Carrito;
import com.gestion.gestionlibros.modelo.Cliente;
import com.gestion.gestionlibros.modelo.Genero;
import com.gestion.gestionlibros.modelo.Libro;

import java.util.List;

public interface DAO {
    public List<Libro> listarLibros();
    public List<Genero> listarGeneros();
    public List<Libro> bucarLibro(String tituloABuscar);
    public Libro obtenerLibroPorId(long idLib);
    public Cliente obtenerClienteId(long idCliente);
    public boolean agregarCliente(Cliente cliente);
    public Cliente buscarCliente(Cliente cliente);
    public boolean ingresarVenta(Cliente cliente, List<Carrito> carritoList);
    public boolean insertarNuevoLibro(Libro libro);
    public boolean eliminarLibro(long idLibro);
    public List<Cliente> listaCliente();
    public boolean editarUsuario(Cliente usuario);
    public boolean eliminarUsuario(long idUsuario);
}
