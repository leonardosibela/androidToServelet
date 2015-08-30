package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaSelectTodos {

	public static void main(String[] args) throws SQLException {
		
		ContatoDAO contatoDAO = new ContatoDAO();
		List<Contato> contatos = new ArrayList<Contato>();
		
		contatos = contatoDAO.selecionaTodos();
		
		for(Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("");
			
		}
	}
	
}
