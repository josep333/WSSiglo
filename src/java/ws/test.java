/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Asus
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Conexion cone = new Conexion();
        Connection c = cone.getConnection();
//        String sql = "select * from cliente";
        String sql = "select * from transferencia t where t.RUT='19219993-k' and t.PASS='123'";
         Statement st;
         ResultSet rs ;
         
        try {
          st = c.createStatement();
           
           rs=st.executeQuery(sql);
        //    System.out.println("paso");
//            while (rs.next()) {
                System.out.println("id"+rs.getInt(1));
//                System.out.println("nombre"+rs.getString(2));
//                System.out.println("rut"+rs.getString(3));
//                System.out.println("****************");
//                
//            }
           c.close();
           rs.close();
           st.close();
            
        } catch (Exception e) {
            System.out.println("fallo");
        }
    }
    
}
