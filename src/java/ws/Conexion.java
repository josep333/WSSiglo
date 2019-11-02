/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class Conexion {
    private static String servidor="jdbc:oracle:thin:@mycm.cl:4921:XE"; 
    private static String usuario ="siglo21";
    private static String contrasenia="siglo21";
    public static String driver="oracle.jdbc.OracleDriver";
    private static Connection conexion;

    public Conexion() {
        try {
            Class.forName(driver);
            conexion=DriverManager.getConnection(servidor, usuario, contrasenia);
            System.out.println("conexion exitosa");
            
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println("conexion fallida");
        }
        
    }
    public Connection getConnection(){
    return conexion;
    }
    
    
}
