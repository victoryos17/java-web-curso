package curso.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.repositorio.RepoCurso;

@WebServlet("/ListarTopicos")
public class ListarTopicos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String curso = request.getParameter("curso" );
		
		RepoCurso repo = new RepoCurso();
		List<String> topicos = repo.obterTopicos( curso);
		
		request.setAttribute( "curso", curso);
		request.setAttribute( "topicos", topicos);

		RequestDispatcher view = request.getRequestDispatcher("listar-topicos.jsp");
		view.forward(request, response);
	}
}
