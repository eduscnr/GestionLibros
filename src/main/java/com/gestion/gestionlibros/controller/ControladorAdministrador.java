package com.gestion.gestionlibros.controller;

import com.gestion.gestionlibros.modelo.Cliente;
import com.gestion.gestionlibros.modelo.Venta;
import com.gestion.gestionlibros.repositorio.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@Controller
public class ControladorAdministrador {
    @Autowired
    private DAO dao;
    @GetMapping("/administrarUsuarios")
    public String getAdministrarUsuarios(Model model){
        model.addAttribute("listaUsuario", dao.listaCliente());
        System.out.println(dao.listaCliente());
        return "verUsuario";
    }
    @GetMapping("/editarUsuario/{idCliente}")
    public String irEditarCliente(@PathVariable("idCliente") long idCliente, Model modelo){
        Cliente c = dao.obtenerClienteId(idCliente);
        modelo.addAttribute("cliente", c);
        return "editarUsuario";
    }
    @PostMapping("/editarUsuario")
    public String editarUsuario(@ModelAttribute("cliente") Cliente cliente, Model modelo){
        if(dao.editarUsuario(cliente)){
            return "redirect:/administrarUsuarios";
        }
        return "error";
    }
    @GetMapping("/mostrarUsuariosyDatos")
    public String mostrarUsuariosyDatos(Model modeloCliente){
        List<Cliente> listaCliente = dao.listaCliente();
        modeloCliente.addAttribute("listaCliente", listaCliente);
        return "mostrarClientesyDatos";
    }
}
