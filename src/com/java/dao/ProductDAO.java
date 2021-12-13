package com.java.dao;


import java.util.List;
import com.java.Product;

public interface ProductDAO {

	void record (Product product);
	List<Product> searchAll();
	Product searchAllForCode(int p_code);
	void att(Product product);
	void remove(int p_code);
	
}
