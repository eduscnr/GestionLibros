package com.gestion.gestionlibros.controller;

import com.gestion.gestionlibros.modelo.*;
import com.gestion.gestionlibros.repositorio.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ControladorUsuario {
    @Autowired
    private IDao dao;
    @Autowired
    private Cliente cliente;
    private List<Carrito> listaCarrito = new ArrayList<>();

    /**
     * Método para agregar un libro a la cesta
     * @param carrito
     * @param model
     * @return JSP de ver todos los libros
     */
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

    /**
     * Método para ver todos los libros
     * @param modelo
     * @param session
     * @return JSP que muesta todos los libros
     */
    @RequestMapping("/verLibros")
    public String verLibros(Model modelo, HttpSession session){
        List<Libro> listaLibros = dao.listarLibros();
        boolean carritoVacio = listaCarrito.isEmpty();
        String rolUsuario = (String) session.getAttribute("rol");
        modelo.addAttribute("libros", listaLibros);
        modelo.addAttribute("carritoVacio", carritoVacio);
        return "listarLibros";//JSP
    }

    /**
     * Método para ir a registrar un nuevo usuario
     * @param model
     * @return
     */
    @GetMapping("/registrar")
    public String irFormulario(Model model){
        model.addAttribute("cliente", cliente);
        return "registro"; //JSP
    }

    /**
     * Método que agregar un nuevo usuario de tipo Usuario
     * @param cliente
     * @param sesion
     * @return redirige al JSP de iniciar sesión
     */
    @PostMapping("/registrar")
    public String agregarUsuario(@ModelAttribute("cliente") Cliente cliente, HttpSession sesion){
        if(dao.agregarCliente(cliente)){
            sesion.setAttribute("usuario", cliente.getNombre());
            sesion.setAttribute("rol", cliente.getRol());
            return "redirect:/";//JSP
        }else{
            return "redirect:/error";
        }
    }

    /**
     * Método que muestea la informacion de un libro
     * @param idLib
     * @param modelo
     * @return JSP para mostrar la información de ese libro
     */
    @GetMapping("/mostrarInformacion/{idLibro}")
    public String mostrarLibro(@PathVariable("idLibro") long idLib, Model modelo){
        Libro l = dao.obtenerLibroPorId(idLib);
        if(l != null){
            modelo.addAttribute("libro", l);
            return "mostrarMasInformacion";//JSP
        }else{
            return "redirect:/error";//JSP
        }
    }

    /**
     * Método que te muestra el inicio de sision
     * @param modelo
     * @return JSP de inicio de sision
     */
    @GetMapping("/")
    public String mostrarInicioSesion(Model modelo){
        modelo.addAttribute("inicioUsuario", cliente);
        modelo.addAttribute("cliente", cliente);
        return "inicioSesion";//JSP
    }

    /**
     * Método que ha un logout de la página
     * @param session
     * @return JSP de inicio de sision
     */
    @GetMapping("/logout")
    public String logout(HttpSession session){
        listaCarrito.clear();
        session.setAttribute("rol", null);
        session.setAttribute("usuario", null);
        cliente = new Cliente();
        return "redirect:/";
    }

    /**
     * Método que realiza el inicio de sision si el usuario existe
     * @param cliente
     * @param sesion
     * @return JSP para ver todos los libros
     */
    @PostMapping("/")
    public String iniciarSesion(@ModelAttribute("inicioUsuario") Cliente cliente, HttpSession sesion){
        Cliente clienteEncotrado = dao.buscarCliente(cliente);
        if(clienteEncotrado != null){
            sesion.setAttribute("usuario", clienteEncotrado.getNombre());
            sesion.setAttribute("rol", clienteEncotrado.getRol());
            this.cliente = clienteEncotrado;
            return "redirect:/verLibros";
        }else{
            return "inicioSesion";//JSP
        }
    }

    /**
     * Método para ver el carrito
     * @param model
     * @return JSP que te muestra el carrito
     */
    @GetMapping("/verCarrito")
    public String verCarrito(Model model){
        model.addAttribute("listaCarrito",listaCarrito);
        return "verCarrito";
    }

    /**
     * Método que realiza el pedido
     * @return JSP para ver de nuevo todos los libros
     */
    @PostMapping("/realizarCompra")
    public String realizarPedido(){
        if(dao.ingresarVenta(cliente, listaCarrito)){
            listaCarrito.clear();
            return "redirect:/verLibros";
        }else{
            return "redirect:/error";//JSP
        }
    }

    /**
     * Método para ver el historial de compra de ese usuario logeado
     * @param model
     * @return JSP que te muestra el historial de compra
     */
    @GetMapping("/verHistorialCompra")
    public String consultarHistorialCompra(Model model) {
        List<DetallesVenta> ventasRealizadas = new ArrayList<>();
        for (Venta venta : cliente.getVentasCliente()) {
            for (DetallesVenta detallesVenta : venta.getDetallesVentasList()) {
                ventasRealizadas.add(detallesVenta);
            }
        }
        model.addAttribute("detallesVentas", ventasRealizadas);
        return "historialCompras";
    }

    /**
     * Método que te lista los libros por genero
     * @param model
     * @return JSP ver los generos
     */
    @GetMapping("/verGeneros")
    public String listarGeneros(Model model){
        List<Genero> generos = dao.listarGeneros();
            model.addAttribute("listaGenero", generos);
        model.addAttribute("listaTodosLosGeneros", generos);
        return "verCategorias";
    }

    /**
     * Método que te muestra el libro buscado
     * @param titulo
     * @param model
     * @return JSP de listar de nuevo todos los libro con ese nombre a buscar
     */
    @GetMapping("/buscarLibros")
    public String buscarLibros(@RequestParam("q") String titulo, Model model) {
        List<Libro> librosEncontrados = dao.bucarLibro(titulo);
        model.addAttribute("libros", librosEncontrados);
        return "listarLibros";
    }

    /**
     * Método que te elimina un libro del carrito
     * @param idLibro
     * @return JSP de ver el carrtio de nuevo
     */
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

    /**
     * Método que te filtra según el genero seleccionado
     * @param genero
     * @param modelo
     * @return JSP para mostrar el genero seleccionado
     */
    @GetMapping("/mostrarLibrosPorGenero")
    public String mostrarLibrosGenero(@RequestParam("generoSeleccionado") String genero, Model modelo){
        List<Genero> listaLibroPorGenero = dao.buscarPorGenero(genero);
        System.out.println(listaLibroPorGenero);
        List<Genero> listarGeneros = dao.listarGeneros();
        modelo.addAttribute("listaGenero", listaLibroPorGenero);
        modelo.addAttribute("listaTodosLosGeneros", listarGeneros);
        return "verCategorias";
    }
    @RequestMapping("/error")
    public String mostrarError(){
        return "error";
    }
    @RequestMapping("/errorInicioSesion")
    public String mostrarErrorInicioSesion(){
        return "errorInicioSesion";
    }

}
