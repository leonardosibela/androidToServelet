package br.com.sibela;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;

public class testaGravar extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			ContatoDAO contatoDAO = new ContatoDAO();
			
			Contato contato = new Contato();
			contato.setNome(request.getParameter("nome"));
			contato.setEmail(request.getParameter("email"));
			contato.setEndereco(request.getParameter("endereco"));
			
			contatoDAO.adiciona(contato);
			
			System.out.println("Gravado com sucesso!!!");
			response.getWriter().print("Gravado com sucesso!!!");

			
			/*
			String jsonString = "oi";
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonString);
			*/
			
		} catch (SQLException e) {
			System.out.println("Erro ao gravar!!!");
			throw new ServletException(e);
		}
	}
	}
}
