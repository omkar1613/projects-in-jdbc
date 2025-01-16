package com.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.controller.StudentController;


public class TestStudent {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		StudentController s=new StudentController();
		StudentController.Connection();

	

		while (true) {

			System.out.println("\t 1: Register For Event");
			System.out.println("\t 2: Display All Student");
			System.out.println("\t 3: Filter Student By event type");
			System.out.println("\t 4: Filter Student By Name");
			System.out.println("\t 5: Count Student For Specific Event");
		
			System.out.println("\t 6: Exit");
			System.out.println("----------------------------------------------------------------------");

			System.out.println("choice an option.....:");
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				s.addEvent();
				break;
				
			case 2:
				s.DisplayAllStudent();
				break;
				
			case 3:
				s.Filterevent();
				break;
				
			case 4:
				s.FilterStudent();
				break;
				
			case 5:
				s.countstudentbyevent();
				break;
				
			case 6:
				System.out.println("Exit..");
				System.exit(0);
				
				
				
				
				
				
				
			}

			
				
	}
	}
}
		
		
		


