package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDAO { 
	
	// a conexão com o banco de dados
	private Connection connection;
	
	public ContatoDAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Contato contato) throws SQLException {
		
		// prepared statement para inserção
		String sql = "insert into contatos (nome,email,endereco) values (?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		// seta os valores
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		
		// executa
		stmt.execute();
		stmt.close();
	}
	
	public List<Contato> selecionaTodos() throws SQLException {
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		PreparedStatement statement = this.connection.prepareStatement("select * from contatos");
		ResultSet rs = statement.executeQuery();
		
		while(rs.next()) {
			
			Contato contato = new Contato();
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			
			contatos.add(contato);
		}
		
		return contatos;
	}
	
}

