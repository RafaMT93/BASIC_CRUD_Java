package com.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilConnection {
	
	public static Connection mkConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest?serverTimezone=UTC", "root", "root");
			System.out.println("Conectado com Sucesso ao Banco de Dados!");

		} catch (Exception e) {
			System.err.println("Não foi possivel estabelecer conexão ao Banco de Dados!");
			e.printStackTrace();
		}
		return conn;
	}
	
	
}
