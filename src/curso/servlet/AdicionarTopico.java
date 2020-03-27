package curso.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.repositorio.RepoCurso;

@WebServlet("/AdicionarTopico")
public class AdicionarTopico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String curso = request.getParameter("curso");
		String novoTopico = request.getParameter("novoTopico");
		
		RepoCurso repo = new RepoCurso();
		repo.adicionarCurso(curso, novoTopico);
		
		response.sendRedirect( request.getContextPath() + "/ListarTopicos?curso=" + curso);
	}
}
