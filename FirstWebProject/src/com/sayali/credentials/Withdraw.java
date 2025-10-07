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
 * Servlet implementation class Withdraw
 */
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
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
		// TODO Auto-generated method stub
		
		Connection con = DBConnection.connect();
		int id = Integer.parseInt(request.getParameter("id"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		try {
			PreparedStatement pstmt = con.prepareStatement("Select balance from customer where id= ?");
			
            pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				
		     int balance = rs.getInt(1);
		     
		   
		     System.out.println("Current Balance : "+rs.getInt(1));
		     balance = balance-amount;
		     
		     PreparedStatement pstmt2 = con.prepareStatement("Update customer set balance = ? where id= ?");
		     pstmt2.setInt(1, balance);
		     pstmt2.setInt(2, id);
		     
		     System.out.println("Updated Balance : "+balance);
		     int i = pstmt2.executeUpdate();
		     
		     if(i>0)
				{
					System.out.println("Amount Withdraw Successfully!!");
				}
		     
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("index.html");
		doGet(request, response);
	}

}
