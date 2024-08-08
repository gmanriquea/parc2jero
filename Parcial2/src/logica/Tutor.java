/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import db.Basedcon;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Tutor {
    private String nombre;
    private String correo;

    public Tutor(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
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
    
    public static boolean Validarexiste(String nombre,String corr){
        boolean existe=false;
        Basedcon cn = new Basedcon();
        ResultSet rs = cn.Seleccionartutores();
        try{
            while(rs.next()){
                if(rs.getString("nombre").equals(nombre) && rs.getString("correo").equals(corr)){
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
    public static boolean Validarinfo(String nombre, String correo){
        boolean error=false;
        if ((nombre.isBlank() || nombre.isEmpty()) && !error){
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
        }
        return !error;
    }
}
