/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author Acer
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Basedcon {
    public void Basedcon(){
        
    };

    private static java.sql.Connection con;
    
    public static String driver  = "com.mysql.jdbc.Driver";
    public static String user = "root";
    public static String pass = "parcial2";
    public static String url = "jdbc:mysql://localhost:3306/dbparcial2";
    
    //public static void main(String[] args) throws SQLException{
    public static Connection conectarbd(){ 
        con = null;
        try {

            con =  DriverManager.getConnection(url, user, pass);
            if (con != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Conexión no exitosa");
        }
           
        /*Operaciones operacion = new Operaciones();
        
        operacion.guardar(con);*/
        return con;
    }
    
    public void Registrarest(Integer codigo, String nombre, String correo, String carrera){
        Connection conexion = conectarbd();
        try {
 
        PreparedStatement insercion;
        
        insercion = conexion.prepareStatement("INSERT INTO " + "estudiantes" + 
                "(codigo, nombre, correo, carrera) VALUES(?,?,?,?)");
        
        insercion.setInt(1, codigo);
        insercion.setString(2, nombre);
        insercion.setString(3, correo);
        insercion.setString(4, carrera);

        
        insercion.executeUpdate();
        
            System.out.println("Registro exitoso");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public ResultSet Seleccionarestuadiantes(){
        Connection cn = conectarbd();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM estudiantes");
        } catch (SQLException e) {
                System.out.println(e);
            }
        return rs;
    }
    public void Registrartut(String nombre, String correo){
        Connection conexion = conectarbd();
        try {
 
        PreparedStatement insercion;
        
        insercion = conexion.prepareStatement("INSERT INTO " + "tutores" + 
                "(nombre,correo) VALUES(?,?)");
        
        insercion.setString(1, nombre);
        insercion.setString(2, correo);

        
        insercion.executeUpdate();
        
            System.out.println("Registro exitoso");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public ResultSet Seleccionartutores(){
        Connection cn = conectarbd();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM tutores");
            } catch (SQLException e) {
                System.out.println(e);
            }
        return rs;
    }
    public void Registrarps( String nombre, String correo, String tutor){
        Connection conexion = conectarbd();
        try {
 
        PreparedStatement insercion;
        
        insercion = conexion.prepareStatement("INSERT INTO " + "psicologoa" + 
                "(nombre, correo, tutor) VALUES(?,?,?)");
        
        insercion.setString(1, nombre);
        insercion.setString(2, correo);
        insercion.setString(3, tutor);

        
        insercion.executeUpdate();
        
            System.out.println("Registro exitoso");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public ResultSet Seleccionarps(){
        Connection cn = conectarbd();
        Statement st;
        ResultSet rs = null;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM psicologoa");
        } catch (SQLException e) {
                System.out.println(e);
            }
        return rs;
    }
}
