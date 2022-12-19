package es.jordi.pruebas.jee;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class Utils {
	private Utils() {}
	
	public static void log(Class origen, String mensaje) {
		System.out.println(origen.getSimpleName() + ": " + mensaje);
	}
	
	public static void log(String cabecera, String mensaje) {
		System.out.println(cabecera + ": " + mensaje);
	}

	public static void log(String mensaje) {
		System.out.println(mensaje);
	}

	/*public static void mostrarInfoVariables(HttpServletRequest req) {
		
		Enumeration<String> nombresVarRequest = req.getAttributeNames();
		String nom;
		StringBuilder sb = new StringBuilder();
		sb.append("---Variables del request---\n--------------------------\n");

		while (nombresVarRequest.hasMoreElements()) {
			nom = nombresVarRequest.nextElement();
			sb.append(nom);
			sb.append(": ");
			sb.append(req.getAttribute(nom));
			sb.append("\n");
		}

		sb.append("---Variables de sesión---\n--------------------------\n");
		HttpSession sesion = req.getSession(false);
		if (sesion != null) {
			Enumeration<String> nombresVarSesion = sesion.getAttributeNames(); 
	
			while (nombresVarSesion.hasMoreElements()) {
				nom = nombresVarSesion.nextElement();
				sb.append(nom);
				sb.append(": ");
				sb.append(sesion.getAttribute(nom));
				sb.append("\n");
			}
		}
		
		sb.append("\n\n");

		System.out.println(sb.toString());
	}*/
	
	
	public static void mostrarInfoVar(HttpServletRequest req) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("-------request-----\n");
		mostrarInfoVariables(sb, req.getAttributeNames(), (clave)->req.getAttribute(clave));
		
		HttpSession sesion = req.getSession(false);
		if (sesion == null) {
			sb.append("-------No hay sesion!-----\n");
		}
		else {
			sb.append("-------session-----\n");
			mostrarInfoVariables(sb, req.getAttributeNames(), (clave)->sesion.getAttribute(clave));
		}
		sb.append("-------parameters-----\n");

		mostrarInfoVariables(sb, req.getParameterNames(), (clave)->{
			String[] valores = req.getParameterValues(clave);
			if (valores.length > 1)
				return Arrays.toString(valores);
			else
				return valores[0];
		});
			
		log(sb.toString());
		
	}
	
	private static void mostrarInfoVariables(StringBuilder sb, Enumeration<String> nombresVar, Function<String, Object> getValor) {
		String nom;
		int i=0;
		while (nombresVar.hasMoreElements()){
			nom = nombresVar.nextElement();
			sb.append(i);
			sb.append("->");
			sb.append(nom);
			sb.append(": ");
			sb.append(getValor.apply(nom));
			sb.append("\n");
		}
	}

}
