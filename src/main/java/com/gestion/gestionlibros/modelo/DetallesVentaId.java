package com.gestion.gestionlibros.modelo;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
@Embeddable
public class DetallesVentaId implements Serializable {
    @ManyToOne
    private Venta idVentas;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_ID_DATELLEVENTAS")
    @SequenceGenerator(name = "SECUENCIA_ID_DATELLEVENTAS", sequenceName = "GENERADOR_ID_DETALLEVENTAS", allocationSize = 1)
    @Column(unique = true)
    private int numLinea;

    public DetallesVentaId() {
    }

    public DetallesVentaId(Venta idVentas, int numLinea) {
        this.idVentas = idVentas;
        this.numLinea = numLinea;
    }

    public Venta getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Venta idVentas) {
        this.idVentas = idVentas;
    }

    public int getNumLinea() {
        return numLinea;
    }

    public void setNumLinea(int numLinea) {
        this.numLinea = numLinea;
    }
}
