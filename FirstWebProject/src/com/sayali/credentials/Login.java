package com.sayali.credentials;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		System.out.println("Email : "+email);
		String password = request.getParameter("password");
		System.out.println("Password : "+password);
		
		Connection con = DBConnection.connect();  // Use your own DB connection logic

        String sql = "SELECT * FROM customer WHERE email = ? AND password = ?";
        PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
		    ps.setString(2, password);

		    ResultSet rs = ps.executeQuery();
		    
		    if (rs.next()) {
	            // Login successful
	            response.sendRedirect("dashboard1.html");
	            System.out.println("Login Successfully");
	        } else {
	            // Invalid login
	            response.sendRedirect("index.html");
	            System.out.println("Invalid password or username");
	        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
