package org.miempresa.demo1.servlets;

import org.miempresa.demo1.dao.ConexionDB;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/consulta1")
public class consulta1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conexion = null;
        Statement stma = null;
        ResultSet resultado = null;
        List<Object[]> datos = new ArrayList<>();

        try {
            conexion = ConexionDB.getConexion();
            String query = "SELECT cl.nro_cedula AS cliente, COUNT(*) AS CantFacturas " +
                    "FROM cliente cl JOIN factura f ON cl.id = f.cliente_id " +
                    "GROUP BY cliente ORDER BY cantfacturas DESC";

            stma = conexion.createStatement();
            resultado = stma.executeQuery(query);

            while (resultado.next()) {
                String cedula = resultado.getString("cliente");
                int cantFacturas = resultado.getInt("CantFacturas");
                datos.add(new Object[]{cedula, cantFacturas});
            }

            req.setAttribute("datosConsulta", datos);
            req.getRequestDispatcher("resultadoConsulta1.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("error", "Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (resultado != null) resultado.close();
                if (stma != null) stma.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}