package com.gestion.gestionlibros.controller;

import com.gestion.gestionlibros.modelo.Cliente;
import com.gestion.gestionlibros.modelo.Libro;
import com.gestion.gestionlibros.repositorio.DAO;
import jakarta.servlet.http.HttpSession;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Cipher;
import java.util.List;
@Controller
public class Controlador {
    @Autowired
    private DAO dao;
    @Autowired
    private Cliente cliente;
    @RequestMapping("/verLibros")
    public String verLibros(Model modelo, HttpSession session){
        List<Libro> listaLibros = dao.listarLibros();
        String rolUsuario = (String) session.getAttribute("rol");
        System.out.println(rolUsuario);
        modelo.addAttribute("libros", listaLibros);
        return "listarLibros";//JSP
    }
    @GetMapping("/")
    public String irFormulario(Model model){
        model.addAttribute("cliente", cliente);
        return "registro"; //JSP
    }
    @PostMapping("/")
    public String agregarUsuario(@ModelAttribute("cliente") Cliente cliente, HttpSession sesion){
        if(dao.agregarCliente(cliente)){
            sesion.setAttribute("usuario", cliente.getNombre());
            sesion.setAttribute("rol", cliente.getRol());
            return "redirect:/verLibros";//JSP
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

    @GetMapping("/iniciarSesion")
    public String mostrarInicioSesion(Model modelo){
        modelo.addAttribute("inicioUsuario", cliente);
        return "inicioSesion";//JSP
    }
    @PostMapping("/iniciarSesion")
    public String iniciarSesion(@ModelAttribute("inicioUsuario") Cliente cliente, HttpSession sesion){
        Cliente clienteEncontrado = dao.buscarCliente(cliente);
        if(clienteEncontrado != null){
            sesion.setAttribute("usuario", clienteEncontrado.getNombre());
            sesion.setAttribute("rol", clienteEncontrado.getRol());
            return "redirect:/verLibros";
        }else{
            return "error";//JSP
        }
    }
}
