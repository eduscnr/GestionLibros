    package com.gestion.gestionlibros.modelo;

    import jakarta.persistence.*;
    import org.springframework.context.annotation.Scope;
    import org.springframework.stereotype.Component;

    import java.util.ArrayList;
    import java.util.List;
    @Component
    @Entity
    @Scope("prototype")
    public class Libro {
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECUENCIA_ID")
        @SequenceGenerator(name = "SECUENCIA_ID", sequenceName = "GENERADOR_ID_LIBROS", allocationSize = 1)
        @Id
        private long idLibro;
        private String titulo;
        @Column(length = 10000)
        private String descripcion;
        private double precio;
        private String isbn;
        private String url;
        @ManyToOne(cascade = CascadeType.PERSIST)
        private Autor autor;
        @ManyToOne(cascade = CascadeType.PERSIST)
        private Genero genero;
        @OneToMany (mappedBy = "libroId")
        private List<DetallesVenta> detallesLibros = new ArrayList<>();

        public Libro() {
        }

        public Libro(String titulo, String descripcion, double precio, String isbn, String url, Autor autor, Genero genero) {
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.precio = precio;
            this.isbn = isbn;
            this.url = url;
            this.autor = autor;
            this.genero = genero;
        }

        public Libro(long idLibro, String titulo, String descripcion, double precio, String isbn) {
            this.idLibro = idLibro;
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.precio = precio;
            this.isbn = isbn;
        }

        public Libro(long idLibro, String titulo, String descripcion, double precio, String isbn, String url, Autor autor, Genero genero) {
            this.idLibro = idLibro;
            this.titulo = titulo;
            this.descripcion = descripcion;
            this.precio = precio;
            this.isbn = isbn;
            this.url = url;
            this.autor = autor;
            this.genero = genero;
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

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }


        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public Autor getAutor() {
            return autor;
        }

        public void setAutor(Autor autor) {
            this.autor = autor;
        }

        public Genero getGenero() {
            return genero;
        }

        public void setGenero(Genero genero) {
            this.genero = genero;
        }

        public List<DetallesVenta> getDetallesLibros() {
            return detallesLibros;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setDetallesLibros(List<DetallesVenta> detallesLibros) {
            this.detallesLibros = detallesLibros;
        }

        @Override
        public String toString() {
            return "Libro{" +
                    "idLibro=" + idLibro +
                    ", titulo='" + titulo + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    ", precio=" + precio +
                    ", isbn='" + isbn + '\'' +
                    ", autor=" + autor +
                    ", genero=" + genero +
                    '}';
        }
    }
