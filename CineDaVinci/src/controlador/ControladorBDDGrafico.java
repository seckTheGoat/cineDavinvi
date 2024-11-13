/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import cinedavinci.Acomodadores;
import cinedavinci.Cine;
import cinedavinci.Pase;
import cinedavinci.Pelicula;
import cinedavinci.Sala;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author sergi
 */
public class ControladorBDDGrafico {

    private Connection conexion;
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    
    public void inicializarConexion() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/bbddseck", "root", "");
            
            s = conexion.createStatement();
            
        } catch (ClassNotFoundException e1) {
            System.out.println("Error al cargar el driver: "+e1.getMessage());
        } catch (SQLException e2) {
            System.out.println("Error al establecer conexion: "+e2.getMessage());
        }
    }
    
    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException e3) {
            System.out.println("Error al cerrar la conexion: "+e3.getMessage());
        }
    }
    
public void crearTablas() {
    try {
        s.execute("CREATE TABLE IF NOT EXISTS peliculas (Titulo VARCHAR(255), PRIMARY KEY(Titulo), Genero VARCHAR(255), Anio INT(4), Director VARCHAR(255), actoresPrincipales VARCHAR(255))");
        s.execute("CREATE TABLE IF NOT EXISTS salas (NumSala INT(3), PRIMARY KEY(NumSala), Planta VARCHAR(255), pases VARCHAR(255), Pelicula VARCHAR(100), FOREIGN KEY (Pelicula) REFERENCES peliculas(Titulo))");
        s.execute("CREATE TABLE IF NOT EXISTS acomodadores (Nombre VARCHAR(20), PRIMARY KEY(Nombre), Apellido VARCHAR(30), Numsala INT(20))");

    } catch (SQLException e4) {
        System.out.println("Error al crear la tabla: " + e4.getMessage());
    }
}

    
    public void guardarEnBDDPeli(ArrayList<Sala> salas){
        try {
            ps = conexion.prepareStatement("INSERT INTO  peliculas VALUES (?,?,?,?,?)");
            for(Sala sala: salas){
                ps.setString(1, sala.getPelicula().getTitulo());
                ps.setString(2, sala.getPelicula().getGenero());
                ps.setInt(3, sala.getPelicula().getAnioCreacion());
                ps.setString(4, sala.getPelicula().getDirector());
                ps.setString(5, sala.getPelicula().getActoresPrincipales());
                
                ps.execute();
            }
            
   
        } catch (SQLException e5) {
            System.out.println("Error SQL: "+e5.getMessage());
        }
    }
    
    

    public void guardarEnBDDSalas( ArrayList<Sala> salas){
        try {
           // s.execute("DELETE FROM salas");
            ps = conexion.prepareStatement("INSERT INTO salas VALUES (?,?,?,?)");
            String pasesTexto="";
            for(Sala sa : salas){
                ps.setInt(1, sa.getNumeroSala());
                ps.setString(2, sa.getPlanta());
                for(Pase pases:sa.getPases()){
                    pasesTexto+=pases.getHora()+" :"+pases.getMinutos()+" nº butacas: "+pases.getNumerosdeButacas()+" | ";
  
                     ps.setString(3, pasesTexto);
                }  
                
                ps.setString(4, sa.getPelicula().getTitulo());
                
                ps.execute();
            }
            
   
        } catch (SQLException e5) {
            System.out.println("Error al insertar sala "+e5.getMessage());
        }
    }
    
    public ArrayList<Pelicula> cargarPelicula() throws SQLException {
        ArrayList<Pelicula> aux = new ArrayList<>();

         
            rs = s.executeQuery("SELECT * FROM peliculas");

            while (rs.next()) {
                Pelicula nuevo = new Pelicula(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                aux.add(nuevo);
            }
        
            return aux;
        
       
    }   
    
      
       public ArrayList<Sala> cargarSalas(Cine cine)throws SQLException {
        ArrayList<Sala> aux = new ArrayList<>();
        
        try {
            rs = s.executeQuery("SELECT * FROM salas");
            while (rs.next()) {
                int numSala=rs.getInt(1);
                String planta=rs.getString(2);
                 ArrayList<Pase> pase= cine.getPases(numSala);
                 Pelicula peli= cine.getPelicula(rs.getString(4));
                         
                        
             Sala sala = new Sala(numSala,planta ,pase,peli) ;
             
                aux.add(sala);
            }
        } catch (SQLException e6) {
            System.out.println("Error al cargar salas: " + e6.getMessage());
        }
        return aux;
    }

         
    
    public void borrarTodasLasSalas() {
        try {
            s.execute("DELETE FROM salas");
        } catch (SQLException e7) {
            System.out.println("Error al borrar todas las salas: " + e7.getMessage());
        }
    }

    public void borrarTodasLasPeliculas() {
        try {
            s.execute("DELETE FROM peliculas");
        } catch (SQLException e8) {
            System.out.println("Error al borrar todas las películas: " + e8.getMessage());
        }
    }
  public ArrayList<Acomodadores> cargarAcomodador() {
        ArrayList<Acomodadores> aux = new ArrayList<>();

        try {
            rs = s.executeQuery("SELECT * FROM acomodadores");

            while (rs.next()) {
                Acomodadores nuevo = new Acomodadores(rs.getString(1), rs.getString(2), rs.getInt(3));
                aux.add(nuevo);
            }
        } catch (SQLException e6) {
            System.out.println("Error al hacer la consulta cargarPeli" + e6.getMessage());
        }
        return aux;
       
    }
  
  public void guardarEnBDDAcomodadore(Acomodadores acomodador ){
        try {
            ps = conexion.prepareStatement("INSERT INTO acomodadores VALUES (?,?,?)");
            ps.setInt(3, acomodador.getNumsala());
                
                ps.setString(2, acomodador.getApellido());
                ps.setString(1, acomodador.getNombre());
                
                ps.execute();
            }
            
   
        catch (SQLException e5) {
            System.out.println("Error al insertar sala "+e5.getMessage());
        }
    }



}
       
    




