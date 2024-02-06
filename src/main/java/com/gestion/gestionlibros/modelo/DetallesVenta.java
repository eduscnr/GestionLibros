package com.gestion.gestionlibros.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Component
@Entity
public class DetallesVenta {

    @EmbeddedId
    private DetallesVentaId detallesVentasId;
    @ManyToOne
    private Libro libroId;
    private int cantidad;
    private double pvp;

    public DetallesVenta() {
    }

    public DetallesVenta(DetallesVentaId detallesVentasId, Libro libroId, int cantidad, double pvp) {
        this.detallesVentasId = detallesVentasId;
        this.libroId = libroId;
        this.cantidad = cantidad;
        this.pvp = pvp;
    }


    public DetallesVentaId getDetallesVentasId() {
        return detallesVentasId;
    }

    public void setDetallesVentasId(DetallesVentaId detallesVentasId) {
        this.detallesVentasId = detallesVentasId;
    }

    public Libro getLibroId() {
        return libroId;
    }

    public void setLibroId(Libro libroId) {
        this.libroId = libroId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    @Override
    public String toString() {
        return "DetallesVentas{" +
                "detallesVentasId=" + detallesVentasId +
                ", libroId=" + libroId +
                ", cantidad=" + cantidad +
                ", pvp=" + pvp +
                '}';
    }
}
