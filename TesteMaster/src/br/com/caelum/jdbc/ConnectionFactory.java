package br.com.caelum.jdbc;

import java.sql.*;

public class ConnectionFactory {
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conectando ao banco");
			return DriverManager.getConnection("jdbc:mysql://localhost/teste", "root", "");
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
