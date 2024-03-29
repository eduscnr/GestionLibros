package com.gestion.gestionlibros.repositorio;

import com.gestion.gestionlibros.modelo.*;

import java.util.Date;
import java.util.List;

public interface IDao {
    public List<Libro> listarLibros();
    public List<Genero> listarGeneros();
    public List<Venta> listarVentaes();
    public List<Autor> listaAutor();
    public List<Libro> bucarLibro(String tituloABuscar);
    public List<Venta> buscarVentaPorFecha(Date fecha);
    public List<Genero> buscarPorGenero(String genero);
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