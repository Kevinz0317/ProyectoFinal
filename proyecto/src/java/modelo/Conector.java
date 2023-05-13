/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author oscar
 */
public class Conector {
    protected static Connection con;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/BaseD";
    private String conf="";
    protected Statement stat;
    
    public Statement getStatement(){
        return this.stat;
    }
    
    public Connection conectar() {
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con=  (Connection) DriverManager.getConnection(url, user, pass);
            stat = (Statement) con.createStatement(); 
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
            return null;
        }
        return con;
    }
    
    public void desconectar(){
        try{
            stat.close();
            con.close();          
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (SQLException e){
            System.out.println(e);
        }
    }
     
}
