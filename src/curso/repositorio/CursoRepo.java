package curso.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import curso.entidade.Curso;
import curso.entidade.Topico;

public class CursoRepo {

	private static final String QUERY_BASE = "select c.id,c.sigla,c.nome,t.id,t.ordem, t.descricao "
						+ "from curso c left outer join topico t on c.id=t.id_curso ";
	private static final String ORDER_BY = " order by c.id,t.ordem";

	public List<Curso> obterCursos() {
		
		List<Curso> cursos = new ArrayList<>();
		Connection conn = BancoCurso.getConnection();
		
		Statement stmt;
		try {
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY_BASE + ORDER_BY);
			boolean continua = rs.next();
			while( continua) {
				
				Long idCurso = rs.getLong("c.id");
				Curso curso = new Curso( idCurso, rs.getString("c.sigla"), rs.getString("c.nome"));
				do {
					
					Long idTopico = rs.getObject( "t.id", Long.class);	
					if( idTopico != null ) {
					
						Topico topico = new Topico( idTopico, rs.getInt("ordem"), rs.getString("descricao"));
						curso.adicionarTopico( topico);
					}
					continua = rs.next();
				} while( continua && rs.getLong("c.id") == idCurso);
				cursos.add( curso);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {

			throw new RuntimeException( e);
		}
		return cursos;
	}

	public Curso obterCurso(Long idCurso) {

		Connection conn = BancoCurso.getConnection();
		
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement( QUERY_BASE + " where c.id=?");
			ps.setLong( 1, idCurso);
			ResultSet rs = ps.executeQuery();
			boolean continua = rs.next();
			if( continua) {
				
				Curso curso = new Curso( idCurso, rs.getString("c.sigla"), rs.getString("c.nome"));
				do {
					
					Long idTopico = rs.getObject( "t.id", Long.class);	
					if( idTopico != null ) {
					
						Topico topico = new Topico( idTopico, rs.getInt("ordem"), rs.getString("descricao"));
						curso.adicionarTopico( topico);
					}
					continua = rs.next();
				} while( continua && rs.getLong("c.id") == idCurso);
				
				return curso;
				
			} else {
				
				throw new IllegalStateException( String.format( "Curso de id=%d nao existe", idCurso));
			}
			
		} catch (SQLException e) {

			throw new RuntimeException( e);
		}
	}

	public void adicionarTopico(Curso curso, Topico topico) {

		final String INSERT_TOPICO = "insert into topico (id_curso, ordem, descricao) values (?, ?, ?)";
		Connection conn = BancoCurso.getConnection();
		try {
			
			PreparedStatement ps = conn.prepareStatement( INSERT_TOPICO);
			ps.setLong( 1, curso.getId());
			ps.setInt( 2, topico.getOrdem());
			ps.setString( 3, topico.getDescricao());
			if( ps.executeUpdate() != 1 ) {
				
				throw new RuntimeException( "Erro ao incluir topico");
			};
			ps.close();
			conn.close();
		} catch (SQLException e) {

			throw new RuntimeException( e);
		}
	}

	public void salvarOrdemTopico(Topico topico) {

		final String UPDATE_ORDEM_TOPICO = "update topico set ordem=? where id=?";
		Connection conn = BancoCurso.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement( UPDATE_ORDEM_TOPICO);
			ps.setInt( 1, topico.getOrdem());
			ps.setLong( 2, topico.getId());
			if( ps.executeUpdate() != 1 ) {
				
				throw new RuntimeException( "Erro ao salvar ordem do topico no curso");
			};
			ps.close();
			conn.close();
		} catch (SQLException e) {

			throw new RuntimeException( e);
		}
	}
}
