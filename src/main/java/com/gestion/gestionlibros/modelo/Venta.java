package com.gestion.gestionlibros.modelo;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Entity
public class Venta {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_ID_VENTAS")
    @SequenceGenerator(name = "SECUENCIA_ID_VENTAS", sequenceName = "GENERADOR_ID_VENTAS", allocationSize = 1)
    @Id
    private long idVenta;
    private Date fechaVenta;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cliente idCliente;
    @OneToMany(mappedBy = "detallesVentasId.idVentas", cascade = CascadeType.ALL)
    private List<DetallesVenta> detallesVentasList = new ArrayList<>();

    public Venta() {
    }

    public Venta(long idVenta, Date fechaVenta, Cliente idCliente) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.idCliente = idCliente;
    }

    public Venta(Date fechaVenta, Cliente idCliente) {
        this.fechaVenta = fechaVenta;
        this.idCliente = idCliente;
    }

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public List<DetallesVenta> getDetallesVentasList() {
        return detallesVentasList;
    }

    public void setDetallesVentasList(List<DetallesVenta> detallesVentasList) {
        this.detallesVentasList = detallesVentasList;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "idVenta=" + idVenta +
                ", fechaVenta=" + fechaVenta +
                ", idCliente=" + idCliente +
                '}';
    }
}
