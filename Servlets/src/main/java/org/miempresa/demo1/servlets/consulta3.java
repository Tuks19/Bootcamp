package org.miempresa.demo1.servlets;

import jakarta.servlet.ServletException;
import org.miempresa.demo1.dao.ConexionDB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import java.util.*;
import java.sql.*;

@WebServlet ("/consulta3")
public class consulta3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resultado = null;
        List<Object[]> datos = new ArrayList<>();

        try {
            conexion = ConexionDB.getConexion();
            String query = "select \n" +
                    "\tm.nombre as Moneda,\n" +
                    "\tcoalesce(count(*),0) as veces_usada\n" +
                    "from moneda m \n" +
                    "\tjoin factura f on m.id = f.moneda_id\n" +
                    "group by m.nombre \n" +
                    "order by veces_usada desc";

            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(query);

            while (resultado.next()) {
                String nombre = resultado.getString("Moneda");
                int veces_usada = resultado.getInt("veces_usada");
                datos.add(new Object[]{nombre, veces_usada});
            }

            req.setAttribute("datosC3", datos);
            req.getRequestDispatcher("resultadoConsulta3.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("Error en la consulta de datos", e);
        } finally {
            try {
                if (resultado != null) resultado.close();
                if (sentencia != null) sentencia.close();
                if (conexion != null) conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}