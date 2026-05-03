package com.shubham;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shubham.dao.EmployeeDao;
import com.shubham.model.Employee;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	
	public EmployeeServlet() {
		
		super();
	}

	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		
		res.getWriter().append("Served at :").append(req.getContextPath());
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/employeeregister.jsp");
		rd.forward(req, res);
		
	}
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String contact = req.getParameter("contact");
		
		Employee emp = new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setUserName(userName);
		emp.setPassword(password);
		emp.setAddress(address);
		emp.setContact(contact);
		
		try {
				EmployeeDao.registerEmployee(emp);
		}catch(Exception ex) {
			ex.getMessage();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/employeedetail.jsp");
		rd.forward(req, res);
		
	}
}
