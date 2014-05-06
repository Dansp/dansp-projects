package br.edu.fatec.util;

import java.sql.*;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {
		try {

			// indica qual é o banco de dados que estou utilizando e seu driver

			Class.forName("com.mysql.jdbc.Driver");

			// estabelece a conexao e retorna uma conexao

			return DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/lokapaka", "root",
					"12345678");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
