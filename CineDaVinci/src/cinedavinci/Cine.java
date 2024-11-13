/*
 * 
 */
package cinedavinci;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Localtime,generos arraylys
 *
 * @author sergi
 */
public class Cine implements Serializable {

    private String NombreCine;
    private String localidad;
    private int año;
    public int plantas;
    private ArrayList<Sala> salas;
    private String dependencias;
        private ArrayList<Pelicula> peliculas;
    private ArrayList<Acomodadores> acomodador;

    // Constructor
    public Cine (String NombreCine, String localidad, int año, int plantas, ArrayList<Sala> salas, String dependencias) {
        this.NombreCine = NombreCine;
        this.localidad = localidad;
        this.año = año;
        this.plantas = plantas;
        this.salas = new ArrayList();
        this.dependencias = dependencias;
        this.peliculas=new ArrayList();
        this.acomodador=new ArrayList();
    }

    // metodo añadir sala
    public void addSala(Sala salas) {
        this.salas.add(salas);
    }

    public void addPelicula(Pelicula peli){
        this.peliculas.add(peli);
        
    }
     public void addAcomodador(Acomodadores peli){
        this.acomodador.add(peli);
        
    }
    //metodo borrar sala
    public void removeSala(Sala salas) {
        this.salas.remove(salas);
    }



    // Método para sacar entradas para una sala determinada en una hora concreta
    public void comprarEntradas(int numeroSala, int hora, int minutos, int numButacas) {
        for (Sala sala : salas) {
            if (sala.getNumeroSala() == numeroSala) {
                for (Pase pase : sala.getPases()) {
                    if (pase.getHora() == hora && pase.getMinutos() == minutos) {
                        int butacasDisponibles = 50;

                        if (  butacasDisponibles >= numButacas) {
                           JOptionPane.showMessageDialog(null,"Entradas disponibles para la Sala " + numeroSala + " a las " + hora + ":" + minutos ); 
                             butacasDisponibles -= numButacas;
                            pase.setNumerosdeButacas( butacasDisponibles);
                            JOptionPane.showMessageDialog(null,"Número de butacas disponibles después de sacar " + numButacas + " entradas: " +  butacasDisponibles);
                        } else {
                          JOptionPane.showMessageDialog(null,"No hay suficientes butacas disponibles para sacar " + numButacas + " entradas.");
                        }
                    }
                }

            }
        }

    }
    

    
    

    //metodo para comprar combo he hecho esto en lugar de hacer un arraylisto con otras dependencias
    public void comprarCombo(int numeroCombo) {
        switch (numeroCombo) {
            
            case 1:
                System.out.println("Combo Mini Mini: Pequeñas palomitas + Pequeño refresco");
                break;
            case 2:
                System.out.println("Combo Max: Palomitas XL + Refresco Grande XL + Hot Dog");
                break;
            case 3:
                System.out.println("Combo Ultra Max: Palomitas XXL + Refresco XXL + Nachos + Hot Dog + Helado");
                break;
            default:
                System.out.println("El combo ultra mega max no esta disponible debido a actualizaciones en los terminos de seguiridad alimenticia");
                break;
        }
    }
    
    //metodo to Strings
    @Override
    public String toString() {
        String texto = "\nCINE"+
                "\n NOMBRE: " + this.NombreCine
                + "\nLOCALIDAD: " + this.localidad
                + "\nAÑO: " + this.año
                + "\nPLANTAS: " + this.plantas
                + "\nOTRAS DEPENDENCIAS: " + this.dependencias;
        for (Sala salas : this.salas) {
            texto += salas.toString();
        }
        return texto;
    }
    
    
    
    //setter y getters

    public String getNombreCine() {
        return NombreCine;
    }

    public void setNombreCine(String NombreCine) {
        this.NombreCine = NombreCine;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPlantas() {
        return plantas;
    }

    public void setPlantas(int plantas) {
        this.plantas = plantas;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<Sala> salas) {
        this.salas = salas;
    }

    public String getDependencias() {
        return dependencias;
    }

    public void setDependencias(String dependencias) {
        this.dependencias = dependencias;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public Pelicula getPelicula(String titulo){
        
        for(Pelicula pelicula:this.getPeliculas()){
            if(pelicula.getTitulo().equalsIgnoreCase(titulo)){
                return pelicula;
            }
        }
       return new Pelicula("","",0,"",""); 
    }
        
    
    public ArrayList<Pase> getPases(int numSala){
        for (Sala sala : this.getSalas()) {
            if (sala.getNumeroSala() == numSala) {
                return sala.getPases();
            }
        }
   
       return null; 
       
    }

    public ArrayList<Acomodadores> getAcomodador() {
        return acomodador;
    }

    public void setAcomodador(ArrayList<Acomodadores> acomodador) {
        this.acomodador = acomodador;
    }
    
    
    
    
    
    
    
    
    
    
    
}
