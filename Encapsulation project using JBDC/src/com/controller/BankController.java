package com.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.model.BankAccount;

public class BankController {

	Scanner sc = new Scanner(System.in);

	public static Connection Connection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_account", "root", "root");
		return con;

	}

	public void addaccount() throws ClassNotFoundException, SQLException {
		BankAccount bankaccount = new BankAccount();
		System.out.println("Add Bank Account :");
		System.out.println("Enter Accno, Name, Balance");

		bankaccount.setAccountnumber(sc.nextInt());
		bankaccount.setName(sc.next());
		bankaccount.setBalence(sc.nextFloat());

		int accno = bankaccount.getAccountnumber();
		String name = bankaccount.getName();
		double balance = bankaccount.getBalence();

		Statement stm = Connection().createStatement();
		String query = " insert into bank values('" + accno + "','" + name + "','" + balance + "')";
		stm.execute(query);
		System.out.println("Account Created Sussfully ...");

	}

	public void viewaccount() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_account", "root", "root");
		CallableStatement cs = con.prepareCall("call selectData");

		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			System.out.println("Account	 Number: " + rs.getInt("accno"));
			System.out.println("Account Name: " + rs.getString("name"));
			System.out.println("Current Balance: " + rs.getDouble("balance"));

			System.out.println("________________________________________________________________________________");
		}
	}

	public void serchaccountbyaccountnumber() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_account", "root", "root");
		System.out.println("Eneter Account Number To Be serch .:");
		int Accno = sc.nextInt();
		boolean found = false;
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			if (Accno == rs.getInt("accno")) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getDouble("balance"));

				System.out.println("________________________________________________________________________________");

			}
			if (found) {
				System.out.println("Account Not Found!");
			}

		}

	}

	public void deposit() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_account", "root", "root");
		Scanner sc = new Scanner(System.in);
		Statement stm = con.createStatement();
		System.out.println("Enter Account Number To Deposit :");
		int ano = sc.nextInt();
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();
		boolean found = false;

		while (rs.next()) {
			if (rs.getInt("accno") == ano) {
				found = true;
				System.out.println("Account Number: " + rs.getInt("accno"));
				System.out.println("Account Hollder Name: " + rs.getString("name"));
				System.out.println("Current Balance: " + rs.getDouble("balance"));

				System.out.println("________________________________________________________________");

				System.out.println("Enter Ammount To Deposite :");
				int ammount = sc.nextInt();

				if (ammount < 0) {
					System.out.println("Account Should Be Greater Then Zero");
					break;
				} else {
					ammount += rs.getInt("balance");

					String query = "update bank set balance ='" + ammount + "' where accno='" + ano + "'";
					stm.executeUpdate(query);
					System.out.println("Deposite Sussfully ....");
				}
			}

		}
		if (!found) {
			System.out.println("Account Number Not Found ..");

		}
		rs.close();
		cs.close();
		con.close();

	}

	public void withdrow() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_account", "root", "root");
		Scanner sc = new Scanner(System.in);
		Statement stm = con.createStatement();
		System.out.println("Enter Account Number To Withdraw:");
		int ano = sc.nextInt();
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();
		boolean found = false;

		while (rs.next()) {
			if (rs.getInt("accno") == ano) {
				found = true;
				int currentBalance = rs.getInt("balance");
				System.out.println("Account Number: " + rs.getInt("accno"));
				System.out.println("Account Holder: " + rs.getString("name"));
				System.out.println("Current Balance: " + currentBalance);
				System.out.println("______________________________________________");

				System.out.println("Enter Amount To Withdraw:");
				int amount = sc.nextInt();

				if (amount <= 0) {
					System.out.println("Amount Should Be Greater Than Zero!");
					break;
				} else {
					int newBalance = currentBalance - amount;
					String query = "UPDATE bank SET balance = '" + newBalance + "' WHERE accno = '" + ano + "'";
					stm.executeUpdate(query);
					System.out.println("Withdrawal Successful! Updated Balance: " + newBalance);
				}
			}
		}

		if (!found) {
			System.out.println("Account Number Not Found!");
		}

		rs.close();
		cs.close();
		con.close();
	}

	public void cheakbalence() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_account", "root", "root");
		System.out.println("Enter Account Number To Check Balance :");
		int accNo = sc.nextInt();

		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs = cs.executeQuery();
		boolean found = false;

		while (rs.next()) {
			if (rs.getInt("accno") == accNo) {
				found = true;
				System.out.println("Account Number :" + rs.getInt("accno"));
				System.out.println("Account Holder Name :" + rs.getString("name"));
				System.out.println("Account Balancecc:" + rs.getDouble("balance"));
				System.out.println("___________________________________________________");
			}

		}
		if (!found) {
			System.out.println("account Number Not Found !!");
		}
		rs.close();
		cs.close();
		con.close();

	}

}
