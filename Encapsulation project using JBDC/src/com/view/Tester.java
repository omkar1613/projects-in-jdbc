package com.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.controller.BankController;
import com.model.BankAccount;

public class Tester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		BankController bank = new BankController();
		BankController.Connection();

		while (true) {

			System.out.println("\t **** welcome to skills it  bank ****");

			System.out.println("\t 1: Add New Account");
			System.out.println("\t 2: Display all account");
			System.out.println("\t 3: Serch account by account number");
			System.out.println("\t 4: Deposit ");
			System.out.println("\t 5: Withdrow");
			System.out.println("\t 6: Cheak Balence");
			System.out.println("\t 7 : Exit \n ");

			System.out.println(
					"----------------------------------------------------------------------------------------------------------");

			System.out.println("Enter your choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				bank.addaccount();
				break;

			case 2:
				bank.viewaccount();
				break;

			case 3:
				bank.serchaccountbyaccountnumber();
				break;

			case 4:
				bank.deposit();
				break;

			case 5:
				bank.withdrow();
				break;
			case 6:
				bank.cheakbalence();
				break;
				
			case 7:
				System.exit(choice);


			}

		}
	}
}