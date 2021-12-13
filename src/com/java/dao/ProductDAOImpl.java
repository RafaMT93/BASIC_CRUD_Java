package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import com.java.Product;
import com.java.UtilConnection;

public class ProductDAOImpl implements ProductDAO {
	
	private Connection conn;
	PreparedStatement pstmt = null;

	@Override
	public void record(Product product) {
		try {
			conn = UtilConnection.mkConnection();
			pstmt = conn.prepareStatement("INSERT INTO T_PRODUTO (NM_PRODUTO, VL_PRODUTO, DT_VALIDADE) VALUES (?, ?, ?)");
			
			pstmt.setString(1, product.getPName());
			pstmt.setDouble(2, product.getPValue());
			pstmt.setDate(3, new java.sql.Date(product.getPValidity().getTimeInMillis()));
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}
	
	@Override
	public List<Product> searchAll(){
		List<Product> products = new ArrayList<Product>();
		ResultSet rs = null;
		
		try {
			conn = UtilConnection.mkConnection();
			pstmt = conn.prepareStatement("SELECT * FROM T_PRODUTO");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				java.sql.Date data = rs.getDate("DT_VALIDADE");
				Calendar p_validity = Calendar.getInstance();
				p_validity.setTimeInMillis(data.getTime());
				Product product = new Product(rs.getString("NM_PRODUTO"), rs.getDouble("VL_PRODUTO") , p_validity);
				products.add(product);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return products;
	}
	
	@Override
	public void att(Product product) {
		try {
			conn = UtilConnection.mkConnection();
			pstmt = conn.prepareStatement("UPDATE T_PRODUTO SET NM_PRODUTO = ?, VL_PRODUTO = ?, DT_VALIDADE = ? WHERE CD_PRODUTO = ?");
			pstmt.setString(1, product.getPName());
			pstmt.setDouble(2, product.getPValue());
			pstmt.setDate(3, new java.sql.Date(product.getPValidity().getTimeInMillis()));
			pstmt.setInt(4, product.getCode());
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@Override
	public void remove(int p_code) {
		try {
			conn = UtilConnection.mkConnection();
			pstmt = conn.prepareStatement("DELETE FROM T_PRODUTO WHERE CD_PRODUTO = ?");
			pstmt.setInt(1, p_code);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Product searchAllForCode(int p_code) {
		Product product = null;
		ResultSet rs = null;
		try {
			conn = UtilConnection.mkConnection();
			pstmt = conn.prepareStatement("SELECT * FROM T_PRODUTO WHERE CD_PRODUTO = ?");
			pstmt.setInt(1, p_code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("NM_PRODUTO");
				double val = rs.getDouble("VL_PRODUTO");
				java.sql.Date data = rs.getDate("DT_VALIDADE");
				Calendar p_validity = Calendar.getInstance();
				p_validity.setTimeInMillis(data.getTime());
				
				product = new Product(name, val, p_validity);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch(SQLException e) {}
		}
		
		
		
		return product;
	}
	


}
