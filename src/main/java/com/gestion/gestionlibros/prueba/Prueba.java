package com.gestion.gestionlibros.prueba;

import com.gestion.gestionlibros.modelo.Autor;
import com.gestion.gestionlibros.modelo.Genero;
import com.gestion.gestionlibros.modelo.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prueba {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("upLibros");
    static EntityManager em = emf.createEntityManager();
    static ApplicationContext context = new ClassPathXmlApplicationContext("configuracion-spring.xml");
    public static void main(String[] args) {
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        /*crearPersistenciaYDatos();*/
    }
    public static void crearPersistenciaYDatos(){

        Genero genero1 = context.getBean("genero", Genero.class);
        genero1.setTipo("Ciencia ficción");
        Genero genero2 = context.getBean("genero", Genero.class);
        genero2.setTipo("Magia");
        Genero genero3 = context.getBean("genero", Genero.class);
        genero3.setTipo("Suspense");
        Genero genero4 = context.getBean("genero", Genero.class);
        genero4.setTipo("Fantasia");
        Genero genero5 = context.getBean("genero", Genero.class);
        genero5.setTipo("Terror");
        Genero genero6 = context.getBean("genero", Genero.class);
        genero6.setTipo("Romance");

        Autor autor1 = context.getBean("autor", Autor.class);
        autor1.setNombre("Suzanne Collins");
        Autor autor2 = context.getBean("autor", Autor.class);
        autor2.setNombre("J. K. Rowling");
        Autor autor3 = context.getBean("autor", Autor.class);
        autor3.setNombre("Jules Verne");
        Autor autor4= context.getBean("autor", Autor.class);
        autor4.setNombre("Daisy Meadows");
        Autor autor5 = context.getBean("autor", Autor.class);
        autor5.setNombre("Stephen King");
        Autor autor6 = context.getBean("autor", Autor.class);
        autor6.setNombre("Mike Lightwood");

        List<Libro> libros = Arrays.asList(
                //Genero1 y Autor1
                new Libro("Los juegos del hambre", "Los Juegos del Hambre es una novela distópica de 2008 de la escritora estadounidense Suzanne Collins. Está escrita desde la perspectiva de Katniss Everdeen, una joven de 16 años que vive en la futura y postapocalíptica nación de Panem, en Norteamérica. El Capitolio, una metrópolis muy avanzada, ejerce el control político sobre el resto de la nación. Los Juegos del Hambre son un acontecimiento anual en el que un chico y una chica de entre 12 y 18 años de cada uno de los doce distritos que rodean el Capitolio son seleccionados por sorteo para competir en una batalla a muerte televisada.",
                        35.5, "8498675391", "https://ia800505.us.archive.org/view_archive.php?archive=/5/items/m_covers_0012/m_covers_0012_87.zip&file=0012878860-M.jpg",
                        autor1, genero1),
                new Libro("En llamas", "Contra todo pronóstico, Katniss Everdeen ha ganado los Juegos del Hambre. Ella y su compañero Peeta Mellark, tributo del Distrito 12, siguen milagrosamente vivos. Katniss debería sentirse aliviada, incluso feliz. Después de todo, ha vuelto con su familia y con su viejo amigo Gale. Sin embargo, nada es como Katniss desea que sea. Gale la mantiene a una distancia glacial. Peeta le ha dado la espalda por completo. Y hay rumores de una rebelión contra el Capitolio, una rebelión que Katniss y Peeta pueden haber ayudado a crear.",
                        30.5, "8427200005", "https://ia800505.us.archive.org/view_archive.php?archive=/5/items/m_covers_0012/m_covers_0012_64.zip&file=0012646474-M.jpg",
                        autor1, genero1),
                new Libro("Los juegos del hambre 3: Sinsajo", "Contra todo pronóstico, Katniss Everdeen ha sobrevivido dos veces a los Juegos del Hambre. Pero ahora que ha salido con vida de la sangrienta arena, aún no está a salvo. El Capitolio está enfadado. El Capitolio quiere venganza. ¿Quién creen que debe pagar por los disturbios? Katniss. Y lo que es peor, el Presidente Snow ha dejado claro que nadie más está a salvo tampoco. Ni la familia de Katniss, ni sus amigos, ni la gente del Distrito 12. Potente e inquietante, esta es la emocionante última entrega de la innovadora trilogía de Los Juegos del Hambre de Suzanne Collins.",
                        40.5, "9788467240870", "https://ia803200.us.archive.org/view_archive.php?archive=/23/items/m_covers_0009/m_covers_0009_25.zip&file=0009254672-M.jpg",
                        autor1, genero1),
                new Libro("Las Tierras Bajas", "Cuando Gregor, de once años, y su hermana de dos se ven arrastrados a un extraño mundo subterráneo, desencadenan una batalla épica en la que intervienen hombres, murciélagos, ratas, cucarachas y arañas, mientras emprenden una búsqueda predicha por una antigua profecía.",
                        15, "9788427200869", "https://ia800505.us.archive.org/view_archive.php?archive=/5/items/m_covers_0012/m_covers_0012_87.zip&file=0012876303-M.jpg",
                        autor1, genero1),
                new Libro("De vloek", "Una plaga amenaza a los habitantes de las Tierras Subterráneas. Buscan la ayuda de Gregor (11) para encontrar una cura para la mortal enfermedad. A partir de unos 9 años.",
                        5, "902066493X", "https://ia600505.us.archive.org/view_archive.php?archive=/10/items/m_covers_0011/m_covers_0011_33.zip&file=0011339340-M.jpg",
                        autor1, genero1),
                new Libro("GREGOR Y LA PROFECIA DE LA DESTRUCCION", "En su segunda aventura, Gregor, un niño de once años, regresa al mundo subterráneo de Nueva York para rescatar a su hermana secuestrada, Boots, y cumplir una profecía que devolverá la paz a las personas, murciélagos, ratas, cucarachas y arañas que pueblan el inframundo.",
                        25, "9781603960151", "https://ia903000.us.archive.org/view_archive.php?archive=/3/items/m_covers_0008/m_covers_0008_76.tar&file=0008760383-M.jpg",
                        autor1, genero1),
                //Genero2 y autor2
                new Libro("Harry Potter y la Piedra Filosofal", "Cuando empiezan a llegar cartas misteriosas a su puerta, Harry Potter nunca ha oído hablar del Colegio Hogwarts de Magia y Hechicería.",
                        50, "9788498386943", "https://covers.openlibrary.org/b/id/14473694-M.jpg",
                        autor2, genero2),
                new Libro("Harry Potter y las Reliquias de la Muerte", "La fecha crucial se acerca. Cuando cumpla diecisiete años, Harry perderá el encantamiento protector que lo mantiene a salvo. El anunciado enfrentamiento a muerte con lord Voldemort es inminente, y la casi imposible misión de encontrar y destruir los restantes Horrocruxes más urgente que nunca.",
                        51.99, "8498381452", "https://ia903000.us.archive.org/view_archive.php?archive=/3/items/m_covers_0008/m_covers_0008_25.tar&file=0008259297-M.jpg",
                        autor2, genero2),
                new Libro("Harry Potter y la orden del Fénix", "Las tediosas vacaciones de verano en la casa de los tíos de Harry todavía no han acabado cuando Harry presiente que algo extraño está sucediento en academia Hogwarts. Cuando por fin comienza otro curso en el famoso colegio de magia y hechicería, sus temores vuelven realidad.",
                        45, "8478889019", "https://ia800505.us.archive.org/view_archive.php?archive=/5/items/m_covers_0012/m_covers_0012_46.zip&file=0012460301-M.jpg",
                        autor2, genero2),
                new Libro("Harry Potter y el prisionero de Azkaban", "Para Harry Potter, es el comienzo de otro año nada ordinario en Hogwarts cuando el Autobús de los Caballeros se estrella en la oscuridad y se detiene bruscamente frente a él.",
                        35, "8478886559", "https://ia600505.us.archive.org/view_archive.php?archive=/5/items/m_covers_0012/m_covers_0012_02.zip&file=0012024856-M.jpg",
                        autor2, genero2),
                new Libro("Harry Potter y la cámara secreta", "Durante las vacaciones de verano posteriores a su primer año en el Colegio Hogwarts de Magia y Hechicería, Harry Potter ha estado recibiendo siniestras advertencias de un elfo de la casa llamado Dobby.",
                        55, "9788498386950", "https://ia601601.us.archive.org/view_archive.php?archive=/25/items/m_covers_0014/m_covers_0014_33.zip&file=0014333284-M.jpg",
                        autor2, genero2),
                new Libro("Harry Potter y el misterio del príncipe", "Con dieciséis años cumplidos, Harry inicia el sexto curso en Hogwarts en medio de terribles acontecimientos que asolan Inglaterra. Elegido capitán del equipo de Quidditch, los entrenamientos, los exámenes y las chicas ocupan todo su tiempo, pero la tranquilidad dura poco. A pesar de los férreos controles de seguridad que protegen la escuela, dos alumnos son brutalmente atacados",
                        25, "8478889949", "https://ia903000.us.archive.org/view_archive.php?archive=/3/items/m_covers_0008/m_covers_0008_25.tar&file=0008259333-M.jpg",
                        autor2, genero2),
                //Genero3 y autor3
                new Libro("Veinte mil leguas de viaje submarino", "Un relato de ciencia ficción del siglo XIX sobre un submarino eléctrico, su excéntrico capitán y el mundo submarino, que anticipó muchos de los logros científicos del siglo XX.",
                        5, "9684322836", "https://ia800505.us.archive.org/view_archive.php?archive=/10/items/m_covers_0011/m_covers_0011_73.zip&file=0011738046-M.jpg",
                        autor3, genero3),
                new Libro("La vuelta al mundo en 80 dias", "En 1872 Phileas Fogg gana una apuesta dando la vuelta al mundo en setenta y nueve días, veintitrés horas y cincuenta y siete minutos.",
                        25, "0965079341","https://covers.openlibrary.org/b/id/7380466-M.jpg",
                        autor3, genero3),
                new Libro("Viaje al centro de la tierra","Tres exploradores descienden al centro de la Tierra, donde se encuentran con tumultuosas tormentas, salvajes animales prehistóricos y feroces cavernícolas.",
                        35, "8420734136", "https://covers.openlibrary.org/b/id/5259484-M.jpg",
                        autor3,genero3),
                new Libro("De la Tierra a la Luna","Texto abreviado de Gisela Silva Encina",
                        23, "8495407884", "https://ia600502.us.archive.org/view_archive.php?archive=/31/items/m_covers_0013/m_covers_0013_77.zip&file=0013772777-M.jpg",
                        autor3,genero3),
                //Genero4 y autor4,
                new Libro("Rubi el Hada Roja","El País de las Hadas es el hogar de siete coloridas hermanas. Juntas son las Hadas del Arco Iris. Ellas mantienen el País de las Hadas deslumbrante y brillante. Pero cuando el malvado Jack Frost las envía lejos, las hermanas se meten en un buen lío. Si no regresan pronto, el País de las Hadas estará condenado a ser gris para siempre.",
                        1, "8484412520", "https://ia800505.us.archive.org/view_archive.php?archive=/25/items/m_covers_0010/m_covers_0010_17.zip&file=0010177032-M.jpg",
                        autor4, genero4),
                new Libro("Ámbar, el hada naranja","El País de las Hadas es el hogar de siete coloridas hermanas. Juntas son las Hadas del Arco Iris. Ellas mantienen el País de las Hadas deslumbrante y brillante. Pero cuando el malvado Jack Frost las envía lejos, las hermanas se meten en un buen lío. Si no regresan pronto, el País de las Hadas estará condenado a ser gris para siempre.",
                        2.5, "8484412539", "https://covers.openlibrary.org/b/id/7277222-M.jpg",
                        autor4, genero4),
                //Genero5 y autor5,
                new Libro("Carrie","La historia de Carrie White, una chica de instituto inadaptada, que descubre poco a poco que tiene poderes telequinéticos. Reprimida por una madre dominante y ultrarreligiosa y atormentada por sus compañeros de instituto, sus esfuerzos por encajar la llevan a un dramático enfrentamiento durante el baile de graduación.",
                        3.5, "8401499666", "https://ia800505.us.archive.org/view_archive.php?archive=/10/items/m_covers_0011/m_covers_0011_55.zip&file=0011555981-M.jpg",
                        autor5, genero5),
                new Libro("El misterio de Salem’s Lot","A Salem’s Lot llega un desconocido, un misterioso anticuario poseedor de un terrible secreto. Paulatinamente, un espíritu diabólico se va apoderando de la localidad. Sin embargo, un escritor, junto con un niño de once años cuya familia ha sido víctima de la maldición se enfrentan al horror que devora a Salem’s Lot. Esta obra ha sido seleccionada por el Literary Guild, uno de los más importantes círculos de lectores de los Estados Unidos. Convertida en serie de Televisión, ha tenido un gran éxito en la pequeña pantalla.",
                        0.5, "8401321360", "https://ia803000.us.archive.org/view_archive.php?archive=/3/items/m_covers_0008/m_covers_0008_14.tar&file=0008147578-M.jpg",
                        autor5, genero5),
                //Genero6 y autor6,
                new Libro("Lo que nunca fuimos","Como muchos millennials que están ya rozando la treintena, Eric atraviesa una situación económica complicada. Decidido a probar suerte en otro sitio, comienza a trabajar en un colegio como monitor de extraescolares. Lo que no sabe es que allí se encontrará a quien menos espera...",
                        15, "8413755859", "https://ia801601.us.archive.org/view_archive.php?archive=/25/items/m_covers_0014/m_covers_0014_29.zip&file=0014295588-M.jpg",
                        autor6, genero6),
                new Libro("La estrella de mis noches","Es la clase de silencio que normalmente solo encuentras con las personas con las que de verdad te sientes cómodo, esas con las que sientes una afinidad especial, y me pregunto si esto no será alguna señal del futuro que me dice que quizá todo puede salir bien si empezamos una relación",
                        35, "8417114904", "https://ia800502.us.archive.org/view_archive.php?archive=/31/items/m_covers_0013/m_covers_0013_45.zip&file=0013455107-M.jpg",
                        autor6, genero6),
                new Libro("Las llamas del incendio","Han pasado dos años desde que Óscar escapó del infierno en el que se había convertido su vida, renaciendo de sus cenizas para arder con su propio fuego. Pero, cuando los fantasmas del pasado regresan para atormentarlo, a veces las llamas se desbocan hasta convertirse en un incendio imposible de controlar",
                        28, "841788646X", "https://ia600502.us.archive.org/view_archive.php?archive=/31/items/m_covers_0013/m_covers_0013_45.zip&file=0013455043-M.jpg",
                        autor6, genero6),
                new Libro("El fuego en el que ardo","Ser gay puede complicarte mucho la vida. ¿Todas esas películas y series que te cuentan lo maravilloso que es ser gay? ¿Estar rodeado de compañeros modernos en el instituto que te quieren como eres? ¿Padres que te apoyan incondicionalmente? Todo mentira. La realidad no es esa.",
                        50, "9788416620197", "https://covers.openlibrary.org/b/id/7425160-M.jpg",
                        autor6, genero6),
                new Libro("El hielo de mis venas","Vivir con culpa no es tarea fácil, y eso es algo que Darío sabe muy bien. Después de todo, el que solía ser su mejor amigo vive un auténtico in erno tras confesarle lo que sentía por él, y lo peor es que Darío no puede hacer nada para arreglar la situación. Atormentado por unas oscuras pesadillas, Darío se enfrenta cada día a su peor enemigo: él mismo. El problema es que es demasiado difícil aceptar lo que siente, sobre todo cuando hacerlo signi caría que tal vez no sea la persona que siempre ha creído ser. El hielo de sus venas se extiende cada vez más, y dependerá solo de él conseguir que se derrita o dejar que se extienda hasta congelarlo por completo.",
                        3, "9788417002046", "https://ia803000.us.archive.org/view_archive.php?archive=/3/items/m_covers_0008/m_covers_0008_09.tar&file=0008099968-M.jpg",
                        autor6, genero6));


        em.getTransaction().begin();
        for (Libro l: libros){
            em.persist(l);
        }
        em.getTransaction().commit();
        em.close();
    }
}
