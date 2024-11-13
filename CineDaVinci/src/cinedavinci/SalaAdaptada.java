/*
 */
package cinedavinci;

import java.util.ArrayList;


public class SalaAdaptada extends Sala{
     private int plazaAdaptadas=5;

    public SalaAdaptada(int numeroSala, String planta, ArrayList<Pase> pases, Pelicula pelicula) {
        super(numeroSala, planta, pases, pelicula);
    }

 
    //sobrescribimos el metodo para sacar Entradas aprovenchando el polimorfismo
  @Override
    public void sacarEntradas(int hora, int minutos, int numButacas) {
        boolean paseEncontrado = false;
        for (Pase pase : getPases()) {
            if (pase.getHora() == hora && pase.getMinutos() == minutos) {
                paseEncontrado = true;
                int butacasDisponibles = pase.getNumerosdeButacas();
                if (butacasDisponibles >= numButacas) {
                    System.out.println("Entradas disponibles para la Sala Adaptada " + getNumeroSala() + " a las " + hora + ":" + minutos);
                    butacasDisponibles -= numButacas;
                    pase.setNumerosdeButacas(butacasDisponibles);
                    System.out.println("Número de butacas disponibles después de sacar " + numButacas + " entradas: " + butacasDisponibles);
                } else {
                    System.out.println("No hay suficientes butacas disponibles para sacar " + numButacas + " entradas en la Sala Adaptada.");
                }
            }
        }
        if (!paseEncontrado) {
            System.out.println("No hay pases disponibles para la hora " + hora + ":" + minutos + " en la Sala Adaptada " + getNumeroSala() + ".");
        }
    }

//setters y getters
    @Override
    public String toString() {
        String texto=super.toString()
                +"Plazas Adaptadas: "+this.plazaAdaptadas;
        return texto;
    }

    public int getPlazaAdaptadas() {
        return plazaAdaptadas;
    }

    public void setPlazaAdaptadas(int plazaAdaptadas) {
        this.plazaAdaptadas = plazaAdaptadas;
    }
     
    
}
