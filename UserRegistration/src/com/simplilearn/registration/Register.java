package com.simplilearn.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("userName");  
		String password=request.getParameter("userPass");  
		String email=request.getParameter("userEmail");  
		String country=request.getParameter("userCountry"); 
		
		System.out.println(name + " | " + password + " | " + email + " | " + country);
		
		try {
		      // 1. Register Driver
		      Class.forName("com.mysql.cj.jdbc.Driver");

		      // 2. Get Connection
		      Connection connection = DriverManager.getConnection(
		          "jdbc:mysql://127.0.0.1:3307/employee",
		          "root",
		          "root123"
		      );

		      Random randomNum = new Random();
		      // 3. Create Statement
		      PreparedStatement preparedStmnt = connection.prepareStatement("INSERT INTO employee_registration values (?,?,?,?,?)");
		      preparedStmnt.setInt(1, randomNum.nextInt());
		      preparedStmnt.setString(2, name);
		      preparedStmnt.setString(3, password);
		      preparedStmnt.setString(4, email);
		      preparedStmnt.setString(5, country);
		      
		      // 4. Execute Query
		      int i = preparedStmnt.executeUpdate();
		      if(i > 0) {
		    	  System.out.println(name + " is registered successfully...");
		      }
		      
		      // 5. Close Connection
		      connection.close();

		    } catch (Exception e) {
		        System.out.println(e);
		    }
	}

}
