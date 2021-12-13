package com.java;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int p_code;
	private String p_name;
	private double p_value;
	private Calendar p_validity;
	
	public Product() {}
	
	public Product(String p_name, double p_value, Calendar p_validity) {
		super();
		this.p_name = p_name;
		this.p_value = p_value;
		this.p_validity = p_validity;
	}
	
	public int getCode() {
		return p_code;
	}
	public String getPName() {
		return p_name;
	}
	public void setPName(String p_name) {
		this.p_name = p_name;
	}
	public double getPValue() {
		return p_value;
	}
	public void setPValue(double p_value) {
		this.p_value = p_value;
	}
	public Calendar getPValidity() {
		return p_validity;
	}
	public void setPValidity(Calendar p_validity) {
		this.p_validity = p_validity;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Produto [codigo=" + p_code + " | Nome = " + p_name + " | Preço = " + p_value + " | Validade = " + sdf.format(p_validity.getTime()) + "]";
	}
	
}
