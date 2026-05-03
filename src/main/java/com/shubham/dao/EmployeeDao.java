package com.shubham.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;
import com.shubham.model.Employee;

public class EmployeeDao {
	
	public  static int registerEmployee(Employee employee) {
		
		String INSERT_USERS_SQL = "INSERT INTO employee" + 
		"(id , first_name, last_name, username, password, address , contact ) VALUES "+
		"(?,?,?,?,?,?,?)";
		
		int result = 0;
		
		try {
			
				Driver d = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(d);
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
			
				PreparedStatement pstmt = con.prepareStatement(INSERT_USERS_SQL);
				pstmt.setInt(1,1);
				pstmt.setString(2,employee.getFirstName());
				pstmt.setString(3, employee.getLastName());
				pstmt.setString(4, employee.getUserName());
				pstmt.setString(5, employee.getPassword());
				pstmt.setString(6, employee.getAddress());
				pstmt.setString(7, employee.getContact());
				
				result = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

}
