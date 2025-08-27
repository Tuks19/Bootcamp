package org.miempresa.demo1.servlets;

import jakarta.servlet.ServletException;
import org.miempresa.demo1.dao.ConexionDB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet ("/InsertClienteServlet")
public class InsertClienteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String cedula = req.getParameter("cedula");
        String telefono = req.getParameter("telefono");
        try {
            conexion = ConexionDB.getConexion();

            int nuevoID = 1;
            String idBD = "SELECT COALESCE (MAX(id)) + 1 as nextID from cliente";
            Statement st = conexion.createStatement();
            rs = st.executeQuery(idBD);

            while (rs.next()){
                nuevoID = rs.getInt("nextID");
            }

            String insertCliente =  "Insert into cliente (id, nombre, apellido, nro_cedula, telefono) values (?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insertCliente);
            ps.setInt(1,nuevoID);
            ps.setString(2,nombre);
            ps.setString(3,apellido);
            ps.setString(4,cedula);
            ps.setString(5,telefono);

            int filas = ps.executeUpdate();

            if (filas > 0 ){
                resp.sendRedirect("exito.jsp");
            }
            else {
                resp.sendRedirect("error.jsp");
            }

        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        } finally {
            try{if (rs != null) { rs.close();}} catch (SQLException _){}
            try{if (ps != null) { ps.close();}} catch (SQLException _){}
            try{if (conexion != null) { conexion.close();}} catch (SQLException _){}
        }
    }
}
