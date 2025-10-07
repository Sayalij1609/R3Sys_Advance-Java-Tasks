package com.sayali.credentials;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CreateAccount
 */
public class CreateAccount extends HttpServlet {
	
	Connection con = DBConnection.connect();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name  = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int  balance = Integer.parseInt(request.getParameter("balance"));
		int id = 0;
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("Insert into customer values (?,?,?,?,?)");
			pstmt.setInt(1,id);
			pstmt.setString(2 ,name );
			pstmt.setString(3 ,email );
			pstmt.setString(4,password);
			pstmt.setInt(5,balance);
			int i = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("index.html");
		
	
		
		
		doGet(request, response);
	}

}
