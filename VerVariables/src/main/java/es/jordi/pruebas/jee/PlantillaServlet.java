package es.jordi.pruebas.jee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlantillaServlet")
public class PlantillaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PlantillaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Utils.mostrarInfoVariables();
		response.getWriter().append("Soy una plantilla, no usar!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
