package com.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.protocol.Resultset;

import com.java.UtilConnection;

public class __TestManual__ {

	public static void main (String[] args) {
		try {
			Connection conn = UtilConnection.mkConnection(); 
			
			Statement stmt = conn.createStatement();

			
			
			/**
			 * INSERT DATA IN DB WITH STORAGE PROCEDURE
			 */
			//CallableStatement cs = conexao.prepareCall("{call PR_INSERT_PRODUTO(?, ?, ?)}");
			//cs.setString(1, "Placa de Video AMD RX 6600 XT Colorfull");
			//cs.setDouble(2, 4599.59);
			//java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			//cs.setDate(3, data);
			//cs.executeUpdate();
			//System.out.println("Produto adicionado com sucesso!");
			
			/**
			 * INSERT IN DATABASE
			*/
			//stmt.executeUpdate("INSERT INTO T_PRODUTO (NM_PRODUTO, VL_PRODUTO, DT_VALIDADE) VALUES ('XBOX SERIES S', 2499.99, '2025-05-21')");
			
			/**
			 * UPDATE LINE IN DATABASE
			*/
			//String sqlUpdate = "UPDATE T_PRODUTO SET VL_PRODUTO = 3599.99 WHERE CD_PRODUTO = 2";
			//stmt.executeUpdate(sqlUpdate);

			/**
			 * DELETE DATA
			*/
			//String sqlDelete = "DELETE FROM T_PRODUTO WHERE CD_PRODUTO = 1";
			//stmt.executeUpdate(sqlDelete);
			
			
			/**
			 * SHOW SQL TABLE IN CONSOLE
			*/
			Resultset result = (Resultset) stmt.executeQuery("SELECT * FROM T_PRODUTO");
			while(((ResultSet) result).next()) {
				System.out.println(((ResultSet) result).getInt("CD_PRODUTO") + " | " + ((ResultSet) result).getString("NM_PRODUTO") + " | " + ((ResultSet) result).getString("VL_PRODUTO") + " | " + ((ResultSet) result).getString("DT_VALIDADE"));
			}
			
			conn.close();
		} catch (SQLException e) {
			System.err.println("Não foi possivel estabelecer conexão ao Banco de Dados!");
			e.printStackTrace();
		} 

	}
}
