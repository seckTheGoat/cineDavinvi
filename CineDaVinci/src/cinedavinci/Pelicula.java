/*
 *
 */
package cinedavinci;

import java.io.Serializable;

/**
 *
 * @author sergi
 */
public class Pelicula implements Serializable {

    private String Titulo;
    private String genero;
    private int anioCreacion;
    private String director;
    private String actoresPrincipales;

    public Pelicula(String Titulo, String genero, int anioCreacion, String director, String actoresPrincipales) {
        this.Titulo = Titulo;
        this.genero = genero;
        this.anioCreacion = anioCreacion;
        this.director = director;
        this.actoresPrincipales = actoresPrincipales;
    }

   //to string
    @Override
    public String toString() {
        String texto = "\nPELICULA: "
                + "\nTITULO: " + this.Titulo
                + "\nANIO CREACION: " + this.anioCreacion
                + "\nDIRECTOR: " + this.director
                + "\nActores Principales: " +this.actoresPrincipales
                + "\n";
      
        return texto;
    }

    
    //setter y getters
    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActoresPrincipales() {
        return actoresPrincipales;
    }

    public void setActoresPrincipales(String actoresPrincipales) {
        this.actoresPrincipales = actoresPrincipales;
    }
    
 
    
}
