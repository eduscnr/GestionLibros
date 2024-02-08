package com.gestion.gestionlibros.controller;

import com.gestion.gestionlibros.modelo.Cliente;
import com.gestion.gestionlibros.modelo.Venta;
import com.gestion.gestionlibros.repositorio.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        List<Venta> listaVenta = dao.listarVentaes();
        modeloCliente.addAttribute("listaVenta", listaVenta);
        modeloCliente.addAttribute("fechasVenta", listaVenta);
        return "mostrarClientesyDatos";
    }
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
