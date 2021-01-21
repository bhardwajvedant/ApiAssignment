package com.vedant;

import javax.servlet.http.HttpServlet;

public class AdditionSubtraction {
	private int addition;
	private int subtraction;
	public AdditionSubtraction(int addition, int subtraction) {
		super();
		this.addition = addition;
		this.subtraction = subtraction;
	}
	public AdditionSubtraction() {
		super();
	}
	public int getAddition() {
		return addition;
	}
	public void setAddition(int addition) {
		this.addition = addition;
	}
	public int getSubtraction() {
		return subtraction;
	}
	public void setSubtraction(int subtraction) {
		this.subtraction = subtraction;
	}

}
