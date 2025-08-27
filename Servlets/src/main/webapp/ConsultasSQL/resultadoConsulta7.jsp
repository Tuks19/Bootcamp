<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 25/8/2025
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultados de Consulta</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Cantidad de Facturas por Cliente</h1>
    <%
        List<Object[]> datos = (List<Object[]>) request.getAttribute("datosC7");
        if (datos == null || datos.isEmpty()) {
    %>
    <p>No se encontraron resultados para la consulta.</p>
    <% } else { %>
    <table>
        <%-- Agrega la columna de cantidad --%>
        <thead>
        <tr>
            <th>Cliente</th>
            <th>Fecha Emision Factura</th>
            <th>Tipo de Factura</th>
            <th>Producto</th>
            <th>Cantidad Comprada</th>
        </tr>
        </thead>
        <tbody>
        <% for (Object[] fila : datos) { %>
        <tr>
            <td><%= fila[0] %></td>
            <td><%= fila[1] %></td>
            <td><%= fila[2] %></td>
            <td><%= fila[3] %></td>
            <td><%= fila[4] %></td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <p>Total de registros: <strong><%= datos.size() %></strong></p>
    <% } %>

    <br>
    <a href="javascript:history.back()" class="btn">← Volver</a>
</div>
</body>
</html>