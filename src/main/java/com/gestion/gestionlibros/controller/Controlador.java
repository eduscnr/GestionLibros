package com.gestion.gestionlibros.controller;

import com.gestion.gestionlibros.modelo.Libro;
import com.gestion.gestionlibros.repositorio.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class Controlador {
    @Autowired
    private DAO dao;
    @RequestMapping("/")
    public String verReservas(Model modelo){
        List<Libro> listaLibros = dao.listarLibros();
        modelo.addAttribute("libros", listaLibros);
        return "listarLibros";//JSP
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
}
