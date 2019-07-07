package dP_Venta;

import dA_ProgVenta.EntidadVendedor;
//import dA_ProgVenta.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {
    PreparedStatement ps;
    ResultSet rs;    
    
    Conexion acceso=new Conexion();
    Connection con;
    
    public EntidadVendedor ValidarVendedor(String dni,String user){
        EntidadVendedor ev=new EntidadVendedor();
        String sql="select * from vendedor where Dni=? and User=?";
        try {
           con=acceso.Conectar();
           ps=con.prepareStatement(sql);
           ps.setString(1, dni);
           ps.setString(2, user);
           rs=ps.executeQuery();
            while (rs.next()) {
                ev.setId(rs.getInt(1));
                ev.setDni(rs.getString(2));
                ev.setNom(rs.getString(3));
                ev.setTel(rs.getString(4));
                ev.setEstado(rs.getString(5));
                ev.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return ev;
    }}