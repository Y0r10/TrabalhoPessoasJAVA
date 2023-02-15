package br.ifpr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConexao() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/pessoa",
				"root", "bancodedados");
		} catch (SQLException e) {
			System.out.println("Deu erro aqui irmao.");
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
