package com.gestion.gestionlibros.controller;

import com.gestion.gestionlibros.modelo.*;
import com.gestion.gestionlibros.repositorio.DAO;
import jakarta.servlet.http.HttpSession;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.List;
@Controller
public class Controlador {
    @Autowired
    private DAO dao;
    @Autowired
    private Cliente cliente;
    @Autowired
    private Libro libros;
    private List<Carrito> listaCarrito = new ArrayList<>();
    @PostMapping("/agregarAlCarrito")
    public String agregarAlCarrito(@ModelAttribute("elementosCarrito") Carrito carrito, Model model) {
        boolean existe = false;
        for (Carrito car : listaCarrito){
            if(car.getIdLibro() == carrito.getIdLibro()){
                car.setCantidad(car.getCantidad()+carrito.getCantidad());
                existe = true;
            }
        }
        if(!existe){
            listaCarrito.add(carrito);
        }
        return "redirect:/verLibros";
    }
    @RequestMapping("/verLibros")
    public String verLibros(Model modelo, HttpSession session){
        List<Libro> listaLibros = dao.listarLibros();
        boolean carritoVacio = listaCarrito.isEmpty();
        String rolUsuario = (String) session.getAttribute("rol");
        modelo.addAttribute("libros", listaLibros);
        modelo.addAttribute("carritoVacio", carritoVacio);
        return "listarLibros";//JSP
    }
    @GetMapping("/registrar")
    public String irFormulario(Model model){
        model.addAttribute("cliente", cliente);
        return "registro"; //JSP
    }
    @PostMapping("/registrar")
    public String agregarUsuario(@ModelAttribute("cliente") Cliente cliente, HttpSession sesion){
        if(dao.agregarCliente(cliente)){
            sesion.setAttribute("usuario", cliente.getNombre());
            sesion.setAttribute("rol", cliente.getRol());
            return "redirect:/";//JSP
        }else{
            return "error";
        }
    }
    @GetMapping("/mostrarInformacion/{idLibro}")
    public String mostrarLibro(@PathVariable("idLibro") long idLib, Model modelo){
        Libro l = dao.obtenerLibroPorId(idLib);
        if(l != null){
            modelo.addAttribute("libro", l);
            return "mostrarMasInformacion";//JSP
        }else{
            return "error";//JSP
        }
    }

    @GetMapping("/")
    public String mostrarInicioSesion(Model modelo){
        modelo.addAttribute("inicioUsuario", cliente);
        modelo.addAttribute("cliente", cliente);
        return "inicioSesion";//JSP
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        listaCarrito.clear();
        session.setAttribute("rol", null);
        session.setAttribute("usuario", null);
        cliente = new Cliente();
        return "redirect:/";
    }
    @PostMapping("/")
    public String iniciarSesion(@ModelAttribute("inicioUsuario") Cliente cliente, HttpSession sesion){
        Cliente clienteEncotrado = dao.buscarCliente(cliente);
        if(clienteEncotrado != null){
            sesion.setAttribute("usuario", clienteEncotrado.getNombre());
            sesion.setAttribute("rol", clienteEncotrado.getRol());
            this.cliente = clienteEncotrado;
            return "redirect:/verLibros";
        }else{
            return "error";//JSP
        }
    }

    @GetMapping("/verCarrito")
    public String verCarrito(Model model){
        model.addAttribute("listaCarrito",listaCarrito);
        return "verCarrito";
    }

    @PostMapping("/realizarCompra")
    public String realizarPedido(){
        if(dao.ingresarVenta(cliente, listaCarrito)){
            listaCarrito.clear();
            return "redirect:/verLibros";
        }else{
            return "error";//JSP
        }
    }

    @GetMapping("/verHistorialCompra")
    public String consultarHistorialCompra(Model model){
        List<DetallesVenta> ventasRealizadas = new ArrayList<>();
        for(Venta venta : cliente.getVentasCliente()){
            for (DetallesVenta detallesVenta : venta.getDetallesVentasList()){
                ventasRealizadas.add(detallesVenta);
            }
        }
        model.addAttribute("detallesVentas", ventasRealizadas);
        return "historialCompras";
    }
    @GetMapping("/edicionLibros")
    public String mostrarLibrosEdicion(Model modelo){
        List<Libro> libros = dao.listarLibros();
        modelo.addAttribute("listaLibros", libros);
        return "edicionLibros";
    }
    @PostMapping("/irNuevoLibro")
    public String nuevoLibro(Model modelo){
        modelo.addAttribute("libro", libros);
        return "nuevoLibro";
    }
    @PostMapping("/nuevoLibro")
    public String enviarLibros(@ModelAttribute("libro") Libro libro){
        if(dao.insertarNuevoLibro(libro)){
            return "redirect:/edicionLibros";
        }
        return "error";
    }
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

    @PostMapping("/editarLibro")
    public String libroEditado(@ModelAttribute("libro") Libro libro){
        if(dao.insertarNuevoLibro(libro)){
            return "redirect:/edicionLibros";
        }
        return "error";
    }

    @GetMapping("/eliminar/{idLibro}")
    public String eliminarLibro(@PathVariable("idLibro") long idLibro){
        if(dao.eliminarLibro(idLibro)){
            return "redirect:/edicionLibros";
        }
        return "error";
    }

    @GetMapping("/verGeneros")
    public String listarGeneros(Model model){
        List<Genero> generos = dao.listarGeneros();
            model.addAttribute("listaGenero", generos);
        model.addAttribute("listaTodosLosGeneros", generos);
        return "verCategorias";
    }
    @GetMapping("/buscarLibros")
    public String buscarLibros(@RequestParam("q") String titulo, Model model) {
        List<Libro> librosEncontrados = dao.bucarLibro(titulo);
        model.addAttribute("libros", librosEncontrados);
        return "listarLibros";
    }

    @GetMapping("/eliminarElemento/{idLibro}")
    public String eliminarElementoCarrito(@PathVariable("idLibro") long idLibro){
        Carrito eliminar = null;
        for (Carrito c : listaCarrito){
            if(c.getIdLibro() == idLibro){
                eliminar = c;
            }
        }
        listaCarrito.remove(eliminar);
        return"redirect:/verCarrito";
    }
    @GetMapping("/mostrarLibrosPorGenero")
    public String mostrarLibrosGenero(@RequestParam("generoSeleccionado") String genero, Model modelo){
        List<Genero> listaLibroPorGenero = dao.buscarPorGenero(genero);
        System.out.println(listaLibroPorGenero);
        List<Genero> listarGeneros = dao.listarGeneros();
        modelo.addAttribute("listaGenero", listaLibroPorGenero);
        modelo.addAttribute("listaTodosLosGeneros", listarGeneros);
        return "verCategorias";
    }

}
