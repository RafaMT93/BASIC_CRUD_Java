package com.java.dao;

public abstract class DAOFactory {
	public static ProductDAO getProductDAO() {
		return new ProductDAOImpl();
	}

}
