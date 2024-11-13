/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import cinedavinci.Cine;
import cinedavinci.Pelicula;
import cinedavinci.Sala;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author sergi
 */
public class Ficheros {

    private String ruta;
//contructor con la ruta

    public Ficheros(String ruta) {
        this.ruta = ruta;
    }

    public Ficheros() {

    }

    //creamos el archivo cine con sus respetivas excepciones
    public void crearArchivo(Cine cine,File fichero ) {
      // File fichero = new File(this.ruta);
        try {
            FileOutputStream fich = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fich);
            oos.writeObject(cine);
            System.out.println("SE HA CREADO EL CINE.DAT");
            oos.close();
            fich.close();
        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encotrada");
        } catch (IOException e2) {
            System.out.println("Archivo no encotrade");
        }

    }
    //Recuperar el contenido del archivo cine.dat y visualizarlo en el main.

    public Cine recuperarFichero(  File fichero) {
       // File fichero = new File(this.ruta);
       Cine cine=null;
        try {
            FileInputStream fich = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fich);
             cine = (Cine) ois.readObject();
           
            ois.close();
            fich.close();
            System.out.println("Se ha recuperado el archivo");
        } catch (FileNotFoundException e1) {
            System.out.println("No has encotrado el archivo");
        } catch (IOException e2) {
            System.out.println("No has encotrado el archivo");
        } catch (ClassNotFoundException e3) {
            System.out.println("La clase cine no se ha encotrado");
        }
        return cine;
    }
    //crear Pelicula  este caso txt

    public void crearPelicula(Cine cine) {

        File fichero = new File(this.ruta);
        try {
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);

            ArrayList<Sala> salas = cine.getSalas();

            for (int i = 0; i < salas.size(); i++) {
                Sala sala = salas.get(i);
                bw.write("\nSala " + sala.getNumeroSala());

                Pelicula peliculas = sala.getPelicula();
                  Pelicula pelicula = sala.getPelicula();
            bw.write("\nTitulo:" + pelicula.getTitulo() + " Actores " + pelicula.getActoresPrincipales());
        
            }
            bw.close();
            fw.close();
            System.out.println("Se ha creado " + this.ruta);
        } catch (FileNotFoundException e1) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e2) {
            System.out.println("Error al escribir en el archivo: ");
        }
    }

    //ver pelicula  .txt 
    public void visualizarPelicula() {
        File fichero = new File(this.ruta);
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
            fr.close();
            System.out.println("Se ha visualizado el archivo " + this.ruta);
        } catch (FileNotFoundException e1) {
            System.out.println("No has encotrado el archivo");
        } catch (IOException e2) {
            System.out.println("Error al leer archivo");

        }
    }

    //creamos archivo para los pases  peliculas.dat
    public void crearArchivoPasesPeliculas(ArrayList<Sala> salas,File fichero ) {
        //File fichero = new File(this.ruta);
        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Escribir cada sala en el archivo
            for (Sala sala : salas) {
                oos.writeObject(sala);
            }

            System.out.println("Se ha creado el archivo " + this.ruta);

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: ");
        }
    }

    //visualizamos pase.dat
    public void visualizarArchivoPasesPeliculas() {
        try (FileInputStream fis = new FileInputStream(ruta); ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    Sala sala = (Sala) ois.readObject();

                    System.out.println(sala);
                } catch (EOFException e) {

                    break;
                } catch (ClassNotFoundException e) {
                    System.out.println("Clase no encontrada durante la lectura: " + e.getMessage());
                    break;
                }
            }

            System.out.println("Se ha visualizado el archivo " + this.ruta);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    //he puesto los datos de la sala porque entiendo que pide datos de la sala + de la peli
    public void crearPasesPeliculasTXT(ArrayList<Sala> salas ,File fichero) {
        //File fichero = new File(this.ruta);

        try {
            FileWriter fw = new FileWriter(fichero);
            BufferedWriter bw = new BufferedWriter(fw);

            // Iterar sobre cada sala y mostrar los datos de cada sala
            for (Sala sala : salas) {
                bw.write("Sala: " + sala.getNumeroSala() + ", Planta: " + sala.getPlanta() + "PASE" + sala.getPases() + "\n");

                // Iterar sobre cada película en la sala
                // Obtener la película de la sala
            Pelicula pelicula = sala.getPelicula();

            // Escribir los detalles de la película
            bw.write("Título: " + pelicula.getTitulo() + "\n");
            bw.write("Género: " + pelicula.getGenero() + "\n");
            bw.write("Año: " + pelicula.getAnioCreacion() + "\n");
            bw.write("Director: " + pelicula.getDirector() + "\n");
            bw.write("Actores Principales: " + pelicula.getActoresPrincipales() + "\n\n");
        }

            bw.close();
            fw.close();
            System.out.println("Archivo " + this.ruta + " creado .");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

    }//metodo para visualizar pelicula txt

    public Cine visualizarPasePeliculaTxt(File fichero) {
      //  File fichero = new File(this.ruta);
     Cine cine=null;
        try {
            FileReader fr = new FileReader(fichero);

            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
            fr.close();
            System.out.println("Archivo " + this.ruta + " visualizado");
        } catch (FileNotFoundException e1) {
            System.out.println("No has encotrado el archivo");
        } catch (IOException e2) {
            System.out.println("Error al leer archivo");

        }
         return cine;
    }

}
