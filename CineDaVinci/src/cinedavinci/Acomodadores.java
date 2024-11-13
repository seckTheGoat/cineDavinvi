/*
 * Clase Acomodador sala examen
 */
package cinedavinci;

/**
 *
 * @author sergi
 */
public class Acomodadores {
        private String Nombre;
    private String Apellido;
    private int numsala;

    public Acomodadores(String Nombre, String Apellido, int numsala) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.numsala = numsala;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getNumsala() {
        return numsala;
    }

    public void setNumsala(int numsala) {
        this.numsala = numsala;
    }

    
    
}
