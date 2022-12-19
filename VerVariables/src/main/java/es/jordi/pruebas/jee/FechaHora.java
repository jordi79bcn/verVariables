package es.jordi.pruebas.jee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FechaHora")
public class FechaHora extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FechaHora() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.append("Served at: ").append(request.getContextPath());
		writer.append("\n");
		writer.append("Hora: ").append(Calendar.getInstance().toInstant().toString());
		
		Utils.mostrarInfoVar(request);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}