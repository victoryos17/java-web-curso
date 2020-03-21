package curso.servlet;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AloMundoServlet")
public class AloMundoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String dataHoraFormatada = LocalDateTime.now().format( DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		response.getWriter().append("<h1>Alo Mundo</h1>")
			.append("<p>Contexto: " + request.getContextPath() + "</p>")
			.append("<p>Data/hora: " + dataHoraFormatada + "</p>");
	}
}
