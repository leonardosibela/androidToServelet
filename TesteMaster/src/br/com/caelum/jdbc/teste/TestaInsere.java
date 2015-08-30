package br.com.caelum.jdbc.teste;

import java.sql.SQLException;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) throws SQLException {

		ContatoDAO contatoDAO = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Apolo");
		contato.setEmail("Apolo@gmail.com");
		contato.setEndereco("Rua do Apolinário");
		
		contatoDAO.adiciona(contato);

		System.out.println("Gravado!");
	}

}
