package curso.repositorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepoCurso {

	private static Map<String, List<String>> topicosPorCurso = new HashMap<>();
	
	static {
		List<String> topicosJava = new ArrayList<>();
		topicosJava.add("Swing");
		topicosJava.add("JDBC");
		topicosJava.add("Servlet e JSP");
		topicosJava.add("Threads");
		topicosJava.add("Generics");
		topicosPorCurso.put( "java", topicosJava);
		List<String> topicosPhp = new ArrayList<>();
		topicosPhp.add("Arrays associativos");
		topicosPhp.add("Funções de Filtro");
		topicosPhp.add("PDO");
		topicosPhp.add("Gerenciamento de Sessão");
		topicosPorCurso.put( "php", topicosPhp);
		List<String> topicosRedes = new ArrayList<>();
		topicosRedes.add("UDP");
		topicosRedes.add("TCP");
		topicosRedes.add("Roteamento");
		topicosRedes.add("Camada Física");
		topicosPorCurso.put( "redes", topicosRedes);
	}
	
	public List<String> obterTopicos(String curso) {

		return RepoCurso.topicosPorCurso.get( curso);
	}
	
	public void adicionarCurso(String curso, String topico) {
		
		RepoCurso.topicosPorCurso.get( curso).add( topico);
	}
}