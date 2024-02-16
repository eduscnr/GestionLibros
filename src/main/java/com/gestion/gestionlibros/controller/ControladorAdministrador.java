package com.gestion.gestionlibros.controller;

import com.gestion.gestionlibros.modelo.*;
import com.gestion.gestionlibros.repositorio.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorAdministrador {
    @Autowired
    private IDao dao;
    @Autowired
    private Libro libros;

    /**
     * Método que realizar la edicion de un nuevo libro
     * @param modelo
     * @return uan vista JSP para editar el libro
     */
    @GetMapping("/edicionLibros")
    public String mostrarLibrosEdicion(Model modelo){
        List<Libro> libros = dao.listarLibros();
        modelo.addAttribute("listaLibros", libros);
        return "edicionLibros";
    }

    /**
     * Método para ir al JSP de un libro nuevo
     * @param modelo
     * @return
     */
    @PostMapping("/irNuevoLibro")
    public String nuevoLibro(Model modelo){
        modelo.addAttribute("libro", libros);
        return "nuevoLibro";
    }

    /**
     * Método para crear un libro nuevo
     * @param libro
     * @return redirge si a sido con exito al JSP de edicionLibros
     */
    @PostMapping("/nuevoLibro")
    public String enviarLibros(@ModelAttribute("libro") Libro libro){
        if(dao.insertarNuevoLibro(libro)){
            return "redirect:/edicionLibros";
        }
        return "redirect:/error";
    }

    /**
     * Método para ver los usuarios
     * @param model
     * @return JSP para ver los usuarios
     */
    @GetMapping("/administrarUsuarios")
    public String getAdministrarUsuarios(Model model){
        model.addAttribute("listaUsuario", dao.listaCliente());
        System.out.println(dao.listaCliente());
        return "verUsuario";
    }

    /**
     * Método para ir a editar un usuario
     * @param idCliente
     * @param modelo
     * @return JSP para editar un usuario
     */
    @GetMapping("/editarUsuario/{idCliente}")
    public String irEditarCliente(@PathVariable("idCliente") long idCliente, Model modelo){
        Cliente c = dao.obtenerClienteId(idCliente);
        modelo.addAttribute("cliente", c);
        return "editarUsuario";
    }

    /**
     * Método para actualizar el usuario en cuestión
     * @param cliente
     * @param modelo
     * @return redirige si todo ha salido bien a la lista de usuarios
     */
    @PostMapping("/editarUsuario")
    public String editarUsuario(@ModelAttribute("cliente") Cliente cliente, Model modelo){
        if(dao.editarUsuario(cliente)){
            return "redirect:/administrarUsuarios";
        }
        return "redirect:/error";
    }

    /**
     * Método para ir a la edicion de un libro
     * @param idLibro
     * @param modelo
     * @return JSP para editar un libro
     */
    @GetMapping("/editarLibro/{idLibro}")
    public String irAEditarLibro(@PathVariable("idLibro") long idLibro,Model modelo){
        Libro libro = dao.obtenerLibroPorId(idLibro);
        List<Genero> listaGenero = dao.listarGeneros();
        List<Autor> listaAutores = dao.listaAutor();
        modelo.addAttribute("listaGenero", listaGenero);
        modelo.addAttribute("listaAutores", listaAutores);
        modelo.addAttribute("libro", libro);
        return "editarLibro";
    }

    /**
     * Método para editar el libro
     * @param libro
     * @return redirige si ha salido correctamente a la lista de todos los libro de edición
     */

    @PostMapping("/editarLibro")
    public String libroEditado(@ModelAttribute("libro") Libro libro){
        if(dao.insertarNuevoLibro(libro)){
            return "redirect:/edicionLibros";
        }
        return "redirect:/error";
    }

    /**
     * Método para eliminar un libro
     * @param idLibro
     * @return si ha salido bien, redirige a la lista de edicion de libros
     */
    @GetMapping("/eliminar/{idLibro}")
    public String eliminarLibro(@PathVariable("idLibro") long idLibro){
        if(dao.eliminarLibro(idLibro)){
            return "redirect:/edicionLibros";
        }
        return "redirect:/error";
    }

    /**
     * Método que muesta todos las venta/detalles venta de todos los clientes
     * @param modeloCliente
     * @return JSP que muestra esos datos
     */
    @GetMapping("/mostrarUsuariosyDatos")
    public String mostrarUsuariosyDatos(Model modeloCliente){
        List<Venta> listaVenta = dao.listarVentaes();
        modeloCliente.addAttribute("listaVenta", listaVenta);
        modeloCliente.addAttribute("fechasVenta", listaVenta);
        return "mostrarClientesyDatos";
    }

    /**
     * Método que realiza la busqueda por una fecha y te devuelve todas las ventas/detalles ventas
     * @param fechaVenta
     * @param modelo
     * @return JSP de todas las ventas/detalles ventas
     */
    @GetMapping("/mostrarDetallesVenta")
    public String mostrarDetallesVentaFecha(@RequestParam("fechaVenta") String fechaVenta, Model modelo){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha esperado
        Date fecha = null;
        try {
            fecha = dateFormat.parse(fechaVenta);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<Venta> listaVenta = dao.buscarVentaPorFecha(fecha);
        modelo.addAttribute("listaVenta", listaVenta);
        modelo.addAttribute("fechasVenta", dao.listarVentaes());
        return "mostrarClientesyDatos";
    }
}
