package org.miempresa.demo1.dao;

import org.miempresa.demo1.models.Cliente;
import java.sql.*;
import javax.sql.DataSource;


public class ClienteDAO {
    private DataSource ds;
    public ClienteDAO(DataSource ds) {
        this.ds = ds;
    }

    public void insertarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nombre, apellido, nro_cedula, telefono) Values (?, ?, ?, ?)";

        try (Connection connection = ds.getConnection();
            PreparedStatement stma = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);)
        {
            stma.setString(1, cliente.getNombre());
            stma.setString(2, cliente.getApellido());
            stma.setString(3, cliente.getNro_cedula());
            stma.setString(4, cliente.getTelefono());

            stma.executeUpdate();

            try (ResultSet rs = stma.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1);}
            }
        }
    }
}
