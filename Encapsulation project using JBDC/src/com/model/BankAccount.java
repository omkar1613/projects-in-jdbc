package com.model;

public class BankAccount {

	private int accno;
	private String name;
	private double balence;
	

	public void cheakbalence() {
		System.out.println("your current balence is :" + balence);
	}

	public int getAccountnumber() {
		return accno;
	}

	public String getName() {
		return name;
	}

	public double getBalence() {
		return balence;
	}

	public void setAccountnumber(int accountnumber) {
		accno = accountnumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBalence(float balence) {
		this.balence = balence;
	}

	public String toString() {
		return "BankAccount [Accountnumber=" + accno + ", name=" + name + ", balence=" + balence + "]";
	}

}
