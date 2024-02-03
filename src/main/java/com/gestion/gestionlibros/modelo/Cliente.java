package com.gestion.gestionlibros.modelo;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Entity
public class Cliente {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_ID_CLIENTE")
    @SequenceGenerator(name = "SECUENCIA_ID_CLIENTE", sequenceName = "GENERADOR_ID_CLIENTE", allocationSize = 1)
    @Id
    private long idCliente;
    private String nombre;
    private String apellido;
    private String tipoDeCuenta;
    @OneToMany(mappedBy = "idCliente", cascade = CascadeType.ALL)
    private List<Venta> ventasCliente = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(long idCliente, String nombre, String apellido, String tipoDeCuenta) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public List<Venta> getVentasCliente() {
        return ventasCliente;
    }

    public void setVentasCliente(List<Venta> ventasCliente) {
        this.ventasCliente = ventasCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tipoDeCuenta='" + tipoDeCuenta + '\'' +
                ", ventasCliente=" + ventasCliente +
                '}';
    }
}