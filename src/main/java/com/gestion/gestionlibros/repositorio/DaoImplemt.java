package com.gestion.gestionlibros.repositorio;

import com.gestion.gestionlibros.modelo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.security.spec.ECField;
import java.util.Date;
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

    @Override
    public Cliente obtenerClienteId(long idCliente) {
        em = emf.createEntityManager();
        return em.find(Cliente.class, idCliente);
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            cliente.setRol("usuario");
            em.persist(cliente);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Cliente buscarCliente(Cliente cliente) {
        em = emf.createEntityManager();
        try{
            Query query = em.createQuery("from Cliente  c where c.nombre = :nombre and c.password = : password");
            query.setParameter("nombre", cliente.getNombre());
            query.setParameter("password", cliente.getPassword());
            Cliente clienteEncontrado = (Cliente) query.getSingleResult();
            return clienteEncontrado;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean ingresarVenta(Cliente cliente, List<Carrito> carritoList) {
        em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Cliente clienteAdministradro = em.merge(cliente);
            Venta v = new Venta(new Date(),clienteAdministradro);
            em.persist(v);
            em.getTransaction().commit();
            for (Carrito carrito : carritoList){
                em.getTransaction().begin();
                DetallesVentaId detallesVentaId = new DetallesVentaId(v);
                detallesVentaId.incrementarNumLinea();
                Libro l = em.find(Libro.class, carrito.getIdLibro());
                DetallesVenta detallesVenta = new DetallesVenta(detallesVentaId, l, carrito.getCantidad(), carrito.getPrecio());
                em.persist(detallesVenta);
                em.getTransaction().commit();
            }
            return true;
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertarNuevoLibro(Libro libro) {
        em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Genero g = em.find(Genero.class, libro.getGenero().getIdGenero());
            Autor a = em.find(Autor.class, libro.getAutor().getIdAutor());
            libro.setAutor(a);
            libro.setGenero(g);
            em.merge(libro);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarLibro(long idLibro) {
        em = emf.createEntityManager();
        Libro l = em.find(Libro.class, idLibro);
        try{
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Cliente> listaCliente() {
        em = emf.createEntityManager();
        String hql = "from Cliente c order by c.id";
        Query q = em.createQuery(hql);
        return q.getResultList();
    }

    @Override
    public boolean editarUsuario(Cliente usuario) {
        em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarUsuario(long idUsuario) {
        em = emf.createEntityManager();
        Cliente c = em.find(Cliente.class, idUsuario);
        try{
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private int incrementarNumLinea(){
        em = emf.createEntityManager();
        Query query = em.createQuery("SELECT MAX(d.detallesVentasId.numLinea) FROM DetallesVenta d");
        int numLineaMax = (int) query.getSingleResult();
        return numLineaMax+1;
    }
}
