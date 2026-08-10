//conexion servidor
package com.demografia.controller;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        
        resp.getWriter().println("¡Hola mundo desde HomeServlet!");
        resp.getWriter().println("El servidor Tomcat está respondiendo correctamente.");
    }
}


/*
//conexion base de datos
package com.demografia.controller;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;import java.sql.Connection;
@WebServlet("/testdb")
public class HomeServlet extends HttpServlet { 
	@Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws
	IOException { Connection conn = com.demografia.config.Conexion.getConnection(); 
if (conn != null) { resp.getWriter().println("¡Conexión con la DB exitosa!"); } else { 
	resp.getWriter().println("No se pudo conectar con la DB."); } 
}
	}
*/