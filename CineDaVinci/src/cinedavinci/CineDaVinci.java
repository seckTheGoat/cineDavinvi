/*
 
 */
package cinedavinci;

import controlador.ControladorBDD;
import controlador.Ficheros;
import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class CineDaVinci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorBDD controlador = new ControladorBDD();
        

        
    /*    controlador.inicializarConexion();
        controlador.crearTablas();
      
        controlador.cerrarConexion();*/
        
        
        
        
        
        
        
        
        
        /*  ***************PASE*****************
         ***********************************/
        ArrayList<Pase> pasesSala1 = new ArrayList<>();
        pasesSala1.add(new Pase(15, 15, 1));
        pasesSala1.add(new Pase(18, 15, 2));
        
        ArrayList<Pase> pasesSala2 = new ArrayList<>();
        pasesSala2.add(new Pase(15, 15, 3));
        pasesSala2.add(new Pase(18, 15, 4));

        ArrayList<Pase> pasesSala3 = new ArrayList<>();
        pasesSala3.add(new Pase(15, 15, 5));
        pasesSala3.add(new Pase(18, 15, 6));

        ArrayList<Pase> pasesSala4 = new ArrayList<>();
        pasesSala4.add(new Pase(15, 15, 6));
        pasesSala4.add(new Pase(18, 15, 7));

        ArrayList<Pase> pasesSala5 = new ArrayList<>();
        pasesSala5.add(new Pase(15, 15, 8));
        pasesSala5.add(new Pase(18, 15, 9));
        
        
        

        /*  ***************SALA*****************
         ***********************************/
        
 Pelicula pelicula1 = new Pelicula("One piece red", "Animación Comedia", 2022, "Goro Taniguchi", "animados");
Pelicula pelicula2 = new Pelicula("The Matrix Resurrections", "Acción Ciencia Ficción", 2021, "Lana Wachowski", "Keanu Reeves, Carrie-Anne Moss, Yahya Abdul-Mateen II");
Pelicula pelicula3 = new Pelicula("Soul", "Animación Comedia Drama", 2020, "Pete Docter", "Jamie Foxx, Tina Fey, Graham Norton");
Pelicula pelicula4 = new Pelicula("Pulp Fiction", "Crimen Drama", 1994, "Quentin Tarantino", "John Travolta, Uma Thurman, Samuel L. Jackson");
Pelicula pelicula5 = new Pelicula("The Shawshank Redemption", "Drama Crimen", 1994, "Frank Darabont", "Tim Robbins, Morgan Freeman, Bob Gunton");
Pelicula pelicula6 = new Pelicula("Forrest Gump", "Drama Romance", 1994, "Robert Zemeckis", "Tom Hanks, Robin Wright, Gary Sinise");
Pelicula pelicula7 = new Pelicula("Inception", "Acción Ciencia Ficción", 2010, "Christopher Nolan", "Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page");
Pelicula pelicula8 = new Pelicula("Interstellar", "Ciencia Ficción Drama", 2014, "Christopher Nolan", "Matthew McConaughey, Anne Hathaway, Jessica Chastain");
Pelicula pelicula9 = new Pelicula("The Dark Knight", "Acción Crimen Drama", 2008, "Christopher Nolan", "Christian Bale, Heath Ledger, Aaron Eckhart");
Pelicula pelicula10 = new Pelicula("The fatherGod", "Crimen Drama", 1972, "Francis Ford Coppola", "Marlon Brando, Al Pacino, James Caan");
Pelicula pelicula11 = new Pelicula("Avatar", "Ciencia Ficción", 2009, "James Cameron", "Sam Worthington, Zoe Saldana, Sigourney Weaver");


         /**********************
         *********SALA*********
         ***********************/
        
      /******************************
         *********Cine Davinci*********
         ****        /******************************
**************************/
        Cine cineDaVinci = new Cine("CINE DAVINCI", "Albacete", 1997, 4, null, "palomitas");
      Sala sala1 = new Sala(1, "Planta 1", pasesSala1, pelicula1);
cineDaVinci.addSala(sala1);

Sala sala2 = new Sala(2, "Planta 1", pasesSala1, pelicula2);
cineDaVinci.addSala(sala2);

Sala sala3 = new Sala(4, "Planta 1", pasesSala3, pelicula3);
cineDaVinci.addSala(sala3);

Sala sala4 = new Sala(3, "Planta 3", pasesSala3, pelicula4);
cineDaVinci.addSala(sala4);

Sala sala5 = new Sala(5, "Planta 3", pasesSala2, pelicula5);
cineDaVinci.addSala(sala5);

Sala sala6 = new Sala(6, "Planta 3", pasesSala2, pelicula6);
cineDaVinci.addSala(sala6);

Sala sala7 = new Sala(7, "Planta 2", pasesSala4, pelicula7);
cineDaVinci.addSala(sala7);

Sala sala8 = new Sala(8, "Planta 2", pasesSala4, pelicula8);
cineDaVinci.addSala(sala8);

Sala sala9 = new Sala(9, "Planta 2", pasesSala5, pelicula9);
cineDaVinci.addSala(sala9);

Sala sala10 = new Sala(10, "Planta 2", pasesSala5, pelicula10);
cineDaVinci.addSala(sala10);
Sala sala11 = new Sala(11, "Planta 2", pasesSala5, pelicula10);
cineDaVinci.addSala(sala10);

    SalaAdaptada salaAdaptada = new SalaAdaptada(10,  "dos", pasesSala1, pelicula11);
      

        cineDaVinci.comprarEntradas(2, 3, 4, 20);
        System.out.println(cineDaVinci.toString());
        cineDaVinci.comprarCombo(2);
        cineDaVinci.addSala(salaAdaptada);
        cineDaVinci.comprarEntradas(2, 15, 15, 4);
             ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
       
        cineDaVinci.addPelicula(pelicula1);
        cineDaVinci.addPelicula(pelicula2);
    
        Ficheros fichero = new Ficheros("./ficheros/cine.dat");
      // fichero.crearArchivo(cineDaVinci);
        //fichero.recuperarFichero();
        
        Ficheros ficheroPelicula = new Ficheros("./ficheros/pelicula.txt");
        ficheroPelicula.crearPelicula(cineDaVinci);
        ficheroPelicula.visualizarPelicula();
        
//        Ficheros ficheroPase = new Ficheros("./ficheros/pases_peliculas.dat");
//        ficheroPase.crearArchivoPasesPeliculas(salas);
//        ficheroPase.visualizarArchivoPasesPeliculas();
//
//        Ficheros ficheroPasePeliculas = new Ficheros("./ficheros/pases_peliculas.txt");
//        ficheroPasePeliculas.crearPasesPeliculasTXT(salas);
//        ficheroPasePeliculas.visualizarPasePeliculaTxt();
    }

}
