/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;
/**
 *
 * @author oscar
 */
public class ControlBase extends Conector implements IConexiones{
    private ResultSet res;
    PreparedStatement st;

    public ControlBase() {
    }
    
    @Override
    public ResultSet consultarDatos(){
        try{  
            res = stat.executeQuery ("SELECT * FROM Datos");
            return res;
        }
        catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    @Override
    public void añadir(String nombre, String email, String contraseña) throws SQLException{   
        try{
            st= (PreparedStatement) con.prepareStatement("INSERT INTO Datos (nombre,email,contra) VALUES (?,?,?)");  
            st.setString(1,nombre);
            st.setString(2, email);
            st.setString(3, contraseña);
            st.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    
}
