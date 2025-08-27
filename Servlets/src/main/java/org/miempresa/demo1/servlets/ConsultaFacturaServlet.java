package org.miempresa.demo1.servlets;

import org.miempresa.demo1.dao.ConexionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import java.io.IOException;

@WebServlet("/ConsultaFacturaServlet")
public class ConsultaFacturaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Object[]> datosC7 = new ArrayList<>();

        // Tomamos el parámetro facturaId
        String idStr = req.getParameter("facturaId");

        if (idStr == null || idStr.trim().isEmpty()) {
            req.setAttribute("error", "Por favor ingrese un ID de factura válido");
            req.getRequestDispatcher("consultas.html").forward(req, resp);
            return;
        }

        try {
            int facturaId = Integer.parseInt(idStr);

            String query = "SELECT fa.fecha_emision as emision, " +
                    "concat(cl.nombre, ' ', cl.apellido) as cliente, " +
                    "ft.nombre as tipo_de_factura, " +
                    "p.nombre as producto, " +
                    "round(fd.cantidad) as cant_comprada " +
                    "FROM factura fa " +
                    "JOIN cliente cl ON fa.cliente_id = cl.id " +
                    "JOIN factura_tipo ft ON fa.factura_tipo_id = ft.id " +
                    "JOIN factura_detalle fd ON fa.id = fd.factura_id " +
                    "JOIN producto p ON fd.producto_id = p.id " +
                    "WHERE fa.id = ?";

            // try-with-resources cierra automáticamente conexión, statement y resultset
            try (Connection conexion = ConexionDB.getConexion();
                 PreparedStatement sentencia = conexion.prepareStatement(query)) {

                sentencia.setInt(1, facturaId);

                try (ResultSet resultado = sentencia.executeQuery()) {
                    while (resultado.next()) {
                        String cliente = resultado.getString("cliente");
                        Date fecha_emision = resultado.getDate("emision");
                        String tipo_factura = resultado.getString("tipo_de_factura");
                        String producto = resultado.getString("producto");
                        int cantidad = resultado.getInt("cant_comprada");

                        datosC7.add(new Object[]{cliente, fecha_emision, tipo_factura, producto, cantidad});
                    }
                }
            }

            // Mandamos los datos a la JSP
            req.setAttribute("datosC7", datosC7);
            req.getRequestDispatcher("resultadoConsulta7.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            req.setAttribute("error", "El ID de factura debe ser un número válido");
            req.getRequestDispatcher("consultas.html").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
            req.setAttribute("error", "Error en la base de datos: " + ex.getMessage());
            req.getRequestDispatcher("consultas.html").forward(req, resp);
        }
    }
}
