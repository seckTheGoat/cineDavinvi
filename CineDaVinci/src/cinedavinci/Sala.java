/*
 */
package cinedavinci;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable {

    private int numeroSala;
    private String planta;
    private ArrayList<Pase> pases;
    private Pelicula pelicula;
   
    public Sala(int numeroSala, String planta, ArrayList<Pase> pases, Pelicula pelicula) {
        this.numeroSala = numeroSala;
        this.planta = planta;
        this.pases = pases;
        this.pelicula = pelicula;
    }

    

   

//metodo para reiniciar la sala
    public void reiniciarSala() {
        this.pases.clear();
        
        System.out.println("La sala " + numeroSala + " ha sido reiniciada y dejada sin datos.");
    }

    public void sacarEntradas(int hora, int minutos, int numButacas) {
        boolean paseEncontrado = false;
        // Iterar sobre los pases de la sala
        for (Pase pase : pases) {
            // Comprobamos  si el pase coincide con la hora y minutos especificados
            if (pase.getHora() == hora && pase.getMinutos() == minutos) {
                paseEncontrado = true;
                // Sacamos  la cantidad de butacas disponibles para este pase
                int butacasDisponibles = pase.getNumerosdeButacas();
                // Verificamos si hay suficientes butacas disponibles
                if (butacasDisponibles >= numButacas) {
                    System.out.println("Entradas disponibles para la Sala " + numeroSala + " a las " + hora + ":" + minutos);
                    butacasDisponibles -= numButacas;
                    pase.setNumerosdeButacas(butacasDisponibles);
                    System.out.println("Número de butacas disponibles después de sacar " + numButacas + " entradas: " + butacasDisponibles);
                } else {

                    System.out.println("No hay suficientes butacas disponibles para sacar " + numButacas + " entradas.");
                }
            }
        }
        // Verificar si se encontró un pase para la hora y minutos especificados
        if (!paseEncontrado) {
            System.out.println("No hay pases disponibles para la hora " + hora + ":" + minutos + " en la Sala " + numeroSala + ".");
        }
    }

    //sala vaciar
    public void isSalaEmpty() throws Exception {
        if (this.pases == null) {
            throw new SalaSinPasesExcepcion("La sala " + numeroSala + " no tiene ningún pase asignado.");
        }
    }
    
    
  
    //metodo to string
    @Override
    public String toString() {

        String texto
                = "\nSALA: "
                + "\nNUMERO DE SALA: " + this.numeroSala
                + "\nPLANTA: " + this.planta
                + "\n";
      
        for (Pase pase : this.pases) {
            texto += pase.toString();
        }

        return texto;

    }

    //setter y getters
    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public ArrayList<Pase> getPases() {
        return pases;
    }

    public void setPases(ArrayList<Pase> pases) {
        this.pases = pases;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    

   

}
