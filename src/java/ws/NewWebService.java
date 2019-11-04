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
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Asus
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

//se instancia la conexion se llama al statemen     
    Conexion cone = new Conexion();
    Connection con = cone.getConnection();
    Statement st;
    ResultSet rs;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "WSSII")
    public int WSSII(@WebParam(name = "id") int id) {
        String sql = "call sp_boleta(" + id + ")";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            con.close();
            st.close();
            rs.close();
            return 1;
        } catch (SQLException e) {
            return 0;
        }

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "WStransferencia")
    public int WStransferencia(@WebParam(name = "run") String run, @WebParam(name = "pass") String pass, @WebParam(name = "montoPago") int montoPago) {
     String valor = "select t.MONTO from transferencia t where t.RUT='" + run + "' and t.PASS='" + pass + "'";
        try {
            st=con.createStatement();
            rs=st.executeQuery(valor);
            
            return 1;
        } catch (Exception e) {
            return 0;
        }


    }

}
