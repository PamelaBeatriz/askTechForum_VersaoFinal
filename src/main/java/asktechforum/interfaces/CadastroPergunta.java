package asktechforum.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import asktechforum.dominio.Pergunta;

public interface CadastroPergunta {
	
	public void adcionarPergunta(Pergunta pergunta) throws SQLException;
	public void deletarPergunta(int id) throws SQLException;
	public Pergunta consultarPerguntaPorIdPergunta(int id) throws SQLException;
	public ArrayList<Pergunta> consultarPerguntaIdUsuario(int id)
			throws SQLException;
	public ArrayList<Pergunta> consultarTodasPerguntas() throws SQLException;
	public ArrayList<Pergunta> consultarPerguntaPorTag(String tag)
			throws SQLException ;
	
}