package org.miempresa.demo1.servlets;

import org.miempresa.demo1.models.Cliente;
import org.miempresa.demo1.dao.ConexionDB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/guardarCliente")
public class manejoCliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String nro_cedula = request.getParameter("nro_cedula");
        String telefono = request.getParameter("telefono");


        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            conexion = ConexionDB.getConexion();

            String sql = "INSERT INTO cliente (nombre, apellido, nro_cedula, telefono) Values (?, ?, ?, ?)";
            ps = conexion.prepareStatement(sql);

            ps.setString(1,nombre);
            ps.setString(2,apellido);
            ps.setString(3,nro_cedula);
            ps.setString(4,telefono);

            int filas_afectadas = ps.executeUpdate();

            Cliente cliente = new Cliente(nombre,apellido,nro_cedula,telefono);
            request.setAttribute("cliente",cliente);

            if(filas_afectadas>0){
                request.setAttribute("mensaje","Cliente guardado correctamente");
            }
            else {
                request.setAttribute("mensaje","No se pudo guardar");
            }
        } catch (SQLException e){
            e.printStackTrace();
            request.setAttribute("mensaje","Error al guardar el cliente " +  e.getMessage());
        } finally {
            try {
                if(ps != null) {ps.close();};
                if(conexion != null) {conexion.close();}
            } catch (SQLException e) {e.printStackTrace();}
        }

    }
}
