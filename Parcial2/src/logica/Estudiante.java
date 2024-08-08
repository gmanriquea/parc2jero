/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import db.Basedcon;
import static db.Basedcon.conectarbd;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Estudiante {
    private final String tabla="estudiantes";
    private Integer codigo;
    private String nombre;
    private String correo;
    private String carrera;

    public Estudiante(Integer codigo, String nombre, String correo, String carrera) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correo = correo;
        this.carrera = carrera;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    /*public void Registrar(Connection conexion,Integer codigo, String nombre, String correo, String carrera){
        try {
 
        PreparedStatement insercion;
        
        insercion = conexion.prepareStatement("INSERT INTO " + this.tabla + 
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
    }*/
    /*public ResultSet Seleccionarestuadiantes(){
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
    }*/
    public static boolean Validarexiste(Integer cod,String corr){
        boolean existe=false;
        Basedcon cn = new Basedcon();
        ResultSet rs = cn.Seleccionarestuadiantes();
        try{
            while(rs.next()){
                if(rs.getInt("codigo")==cod && rs.getString("correo").equals(corr)){
                    existe=true;
                    //System.out.println(rs.getInt("indice"));
                    break;
                }
            }
        }
        catch(Exception e){
            
        }
        return existe;
    }
    public static boolean Validarinfo(String codigo,String nombre, String correo, String carrera){
        boolean error=false;
        if(codigo.isEmpty() || codigo.isBlank()){
            JOptionPane.showMessageDialog(null, "No has ingresado nada en el campo CODIGO");
            error=true;
        }
        else{
            String str=codigo;
            boolean esnumero =  str.matches("[+-]?\\d*(\\.\\d+)?");
            if(!esnumero){
                JOptionPane.showMessageDialog(null, "No has ingresado un valor numerico");
                error=true;
            }else{
                error=false;
            }
        }if ((nombre.isBlank() || nombre.isEmpty()) && !error){
            JOptionPane.showMessageDialog(null, "No has ingresado nada en el campo NOMBRE");
            error=true;
        }else if (!(nombre.isBlank() || nombre.isEmpty()) && !error){
            error=false;
        }
        if ((correo.isBlank() || correo.isEmpty()) && !error ){
            JOptionPane.showMessageDialog(null, "No has ingresado nada en el campo CORREO");
            error=true;
        }
        else if (!(correo.isBlank() || correo.isEmpty()) && !error ){
            String reg = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  
            //Compile regular expression to get the pattern  
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(correo); 
            if (matcher.matches()){
                error=false;
            }else{
                JOptionPane.showMessageDialog(null, "Lo ingresado en el campo CORREO no consiste con la estructura de un correo electronico(ejemplo@ejemplo.com)");
                error=true;
            }
        }if ((carrera.isBlank() || carrera.isEmpty()) && !error){
            JOptionPane.showMessageDialog(null, "No has ingresado nada en el campo CARRERA");
            error=true;
        }else if (!(carrera.isBlank() || carrera.isEmpty()) && !error){
            error=false;
        }
        return !error;
    }
    public static boolean Validarinfo(String codigo,String correo){
        boolean error=false;
        if(codigo.isEmpty() || codigo.isBlank()){
            JOptionPane.showMessageDialog(null, "No has ingresado nada en el campo CODIGO");
            error=true;
        }
        else{
            String str=codigo;
            boolean esnumero =  str.matches("[+-]?\\d*(\\.\\d+)?");
            if(!esnumero){
                JOptionPane.showMessageDialog(null, "No has ingresado un valor numerico");
                error=true;
            }else{
                error=false;
            }
        }if ((correo.isBlank() || correo.isEmpty()) && !error ){
            JOptionPane.showMessageDialog(null, "No has ingresado nada en el campo CORREO");
            error=true;
        }
        else if (!(correo.isBlank() || correo.isEmpty()) && !error ){
            String reg = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  
            //Compile regular expression to get the pattern  
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(correo); 
            if (matcher.matches()){
                error=false;
            }else{
                JOptionPane.showMessageDialog(null, "Lo ingresado en el campo CORREO no consiste con la estructura de un correo electronico(ejemplo@ejemplo.com)");
                error=true;
            }
        }
        return !error;
    }
    
}
