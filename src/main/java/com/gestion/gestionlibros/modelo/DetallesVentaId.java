package com.gestion.gestionlibros.modelo;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
@Embeddable
public class DetallesVentaId implements Serializable {
    @ManyToOne
    private Venta idVentas;

    @Column(unique = true)
    private int numLinea;

    public DetallesVentaId() {
    }

    public DetallesVentaId(Venta idVentas, int numLinea) {
        this.idVentas = idVentas;
        this.numLinea = numLinea;
    }
    public void incrementarNumLinea(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("upLibros");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT MAX(d.detallesVentasId.numLinea) FROM DetallesVenta d");
        if(query != null){
            int numLineaMax = (int) query.getSingleResult();
            em.close();
            numLinea = numLineaMax+1;
        }else{
            numLinea = 1;
            em.close();
        }
    }

    public DetallesVentaId(Venta idVentas) {
        this.idVentas = idVentas;
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
