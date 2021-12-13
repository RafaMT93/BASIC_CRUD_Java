package com.java;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.java.dao.ProductDAO;
import com.java.dao.ProductDAOImpl;

public class __TestDinamicCrud__ {

	public static void main (String[] args) {

		ProductDAO dao = new ProductDAOImpl();
		
		//Product product = new Product();
		//product.setPName("Placa de Video NVIDIA RTX 3090");
		//product.setPValue(17582.99);
		//Calendar calendar = new GregorianCalendar(2025, 01, 13);
		//product.setPValidity(calendar);
		
		//dao.record(product);
		List<Product> products = dao.searchAll();
		for(Product prod: products) {
			System.out.println(prod.toString());
		}
			

	}
}
