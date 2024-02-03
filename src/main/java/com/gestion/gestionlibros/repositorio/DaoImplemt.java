package com.gestion.gestionlibros.repositorio;

import com.gestion.gestionlibros.modelo.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DaoImplemt implements DAO{
    EntityManagerFactory emf;
    EntityManager em;
    String up="upLibros";
    public DaoImplemt(){
        emf = Persistence.createEntityManagerFactory(up);
    }
    @Override
    public List<Libro> listarLibros() {
        em = emf.createEntityManager();
        String hql = "from Libro l order by l.id";
        Query q = em.createQuery(hql);
        return q.getResultList();
    }

    @Override
    public Libro obtenerLibroPorId(long idLib) {
        em = emf.createEntityManager();
        return em.find(Libro.class, idLib);
    }
}
