package org.miempresa.demo1;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/saludo") // Add WebServlet annotation for mapping
public class SaludoServlet extends HttpServlet {

    private String mensaje; // Declare as instance variable

    public void init() {
        mensaje = "Hola Juan"; // Initialize the instance variable
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><body>");
        out.println("<h1>" + mensaje + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {}
}