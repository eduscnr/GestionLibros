package com.gestion.gestionlibros.modelo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Carrito {
    private long idLibro;
    private String titulo;
    private double precio;
    private int cantidad;
    private String url;

    public Carrito() {
    }

    public Carrito(long idLibro, String titulo, double precio, int cantidad, String url) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.url = url;
    }

    public long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", url='" + url + '\'' +
                '}';
    }
}
