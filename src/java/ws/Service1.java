/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.CallableStatement;
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
@WebService(serviceName = "Service1")
public class Service1 {

//se instancia la conexion se llama al statemen     
    Conexion cone = new Conexion();
    Connection con = cone.getConnection();
    Statement st;
    ResultSet rs, proce;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "WSSII")
    public int WSSII(@WebParam(name = "id") int id) {
        String sql = "call sp_boleta(?)";
        try {
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(id, id);
            statement.execute();
            con.close();
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
            st = con.createStatement();
            rs = st.executeQuery(valor);
            int res = 0;
            while (rs.next()) {
                res = rs.getInt(1);
                //  System.err.println(res);
            }
            int monto = res - montoPago;
//            String procedimiento="call  SP_TRANSFERENCIA ('"+run+"','"+pass+"',"+monto+")";
//            proce=st.executeQuery(procedimiento);
//            System.out.println("señor jesucristo"+monto);

            String query = "{call  SP_TRANSFERENCIA(?,?,?)}";
            CallableStatement statement = con.prepareCall(query);
            statement.setString(1, run);
            statement.setString(2, pass);
            statement.setInt(3, monto);
            statement.execute();

            return monto;
        } catch (Exception e) {
            System.out.println(e.getMessage() + " se mamo");
            return 0;
        }

    }

}
