package com.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.model.Student;

public class StudentController {
	Scanner sc=new Scanner(System.in);
	
	public static Connection Connection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techincalevent", "root", "root");
		return con;

	}
	
	public void addEvent() throws ClassNotFoundException, SQLException {
		Student student=new Student();
		System.out.println("Enter Event :");
		System.out.println("Enter student details like->id, name,age,strem,eventtype");
		
		student.setStudentid(sc.nextInt());
		student.setStuname(sc.next());
		student.setAge(sc.nextInt());
		student.setStream(sc.next());
		student.setEventtype(sc.next());
		
		int id=student.getStudentid();
		String name=student.getStuname();
		int age=student.getAge();
		String stream=student.getStream();
		String eventtype=student.getEventtype();
		
		Statement stm=Connection().createStatement();
		String query="insert into student values('"+id+"','"+name+"','"+age+"','"+stream+"','"+eventtype+"')";
		stm.execute(query);
		System.out.println("Data Added successfully....");
		System.out.println("_______________________________________");
	}
		
	
	public void DisplayAllStudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techincalevent", "root", "root");
		CallableStatement cs = con.prepareCall("{call selectData()}");
		
		ResultSet rs=cs.executeQuery();
		while(rs.next()) {
			System.out.println("Student Id:"+rs.getInt(1));
			System.out.println("Student Name:"+rs.getString(2));
			System.out.println("student age:"+rs.getInt(3));
			System.out.println("Student Stream:"+rs.getString(4));
			System.out.println("Student EventType:"+rs.getString(5));
			System.out.println("____________________________________");
		}
		
		
	}
	
	public void Filterevent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techincalevent", "root", "root");
		System.out.println("Filter Student By Event Type:");
		String event=sc.next();
		boolean found=false;
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs=cs.executeQuery();

		while(rs.next()) {
			if(event.equals(rs.getString("eventype"))) {
				found=true;
				System.out.println(rs.getInt("studentid"));
				System.out.println(rs.getString("stuname"));
				System.out.println(rs.getInt("age"));
				System.out.println(rs.getString("stream"));
				System.out.println(rs.getString("eventype"));
				break;
			}
			
		}
		if(!found) {
			System.out.println("Event Not Found!! ");
		}

		
	}
	
	public void FilterStudent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techincalevent", "root", "root");
		System.out.println("filter Student By Name:");
		String n=sc.next();
		boolean found=false;
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs=cs.executeQuery();
		while(rs.next()) {
			if(n.equals(rs.getString("stuname"))) {
				found =true;
				
				System.out.println(rs.getInt("studentid"));
				System.out.println(rs.getString("stuname"));
				System.out.println(rs.getInt("age"));
				System.out.println(rs.getString("stream"));
				System.out.println(rs.getString("eventype"));
				System.out.println("_________________________________");
				break;
			}
		}
		if(!found) {
			System.out.println("Event Not Found !!");
		}
		
	}
	
	public void countstudentbyevent() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techincalevent", "root", "root");
		System.out.println("Count Student For Specific Event ");
		String evenTtype=sc.next();
		boolean found=false;
		int count=0;
		CallableStatement cs = con.prepareCall("{call selectData()}");
		ResultSet rs=cs.executeQuery();
		while(rs.next()) {
			if(evenTtype.equals(rs.getString("eventype"))) {
				found=true;
				count++;
			}
		}
		if(!found) {
			System.out.println("Event Type Not Found!!");
		}
		System.out.println("Total Count :"+count);
		System.out.println("____________________________________");
		
		
	}
	
		

		
	}
