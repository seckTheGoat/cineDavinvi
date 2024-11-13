/*
 */
package cinedavinci;

import java.io.Serializable;

/**
 *
 * @author sergi
 */
public class Pase implements Serializable{
    private int hora;
    private int minutos;
    private int numerosdeButacas ; 

    public Pase(int hora, int minutos, int numerosdeButacas) {
        this.hora = hora;
        this.minutos = minutos;
        this.numerosdeButacas = numerosdeButacas;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getNumerosdeButacas() {
        return numerosdeButacas;
    }

    public void setNumerosdeButacas(int numerosdeButacas) {
        this.numerosdeButacas = numerosdeButacas;
    }

    @Override
    public String toString() {
        String texto= "\nPASE" +
                "\n HORA: " + this.hora 
                + " \n MINUTOS:"  + this.minutos 
                + "\n NUMEROS DE BUTACAS: "  + this.numerosdeButacas 
                + "\n";
                  
        return texto;
    }
    
}
