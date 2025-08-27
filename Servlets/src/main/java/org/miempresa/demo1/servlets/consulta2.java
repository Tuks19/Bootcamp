package org.miempresa.demo1.servlets;

import org.miempresa.demo1.dao.ConexionDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.text.NumberFormat;
import java.util.*;

@WebServlet ("/consulta2")
public class consulta2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet resultado = null;
        List<Object[]> datos = new ArrayList<>();

        try {
            conn = ConexionDB.getConexion();
            String query = "select \n" +
                    "\tcl.nro_cedula as cliente, \n" +
                    "\tround(coalesce(sum(fd.cantidad * p.costo ), 0)) as totalGastado\n" +
                    "from cliente cl\n" +
                    "\tjoin factura f on cl.id = f.cliente_id\n" +
                    "\tjoin factura_detalle fd on f.id = fd.factura_id\n" +
                    "\tjoin producto p on fd.producto_id = p.id\n" +
                    "group by cliente \n" +
                    "order by totalgastado desc";

            stmt = conn.createStatement();
            resultado = stmt.executeQuery(query);

            while (resultado.next()) {
                String cedula = resultado.getString("cliente");
                long totalGastado = resultado.getLong("totalGastado");
                NumberFormat formateador = NumberFormat.getNumberInstance(Locale.getDefault());
                String totalFormateado = formateador.format(totalGastado);
                datos.add(new Object[]{cedula, totalFormateado});
            }

            req.setAttribute("datosC2", datos);
            req.getRequestDispatcher("resultadoConsulta2.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("error", "Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (resultado != null) resultado.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
