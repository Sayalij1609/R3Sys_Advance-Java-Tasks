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
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
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
		int id1 = Integer.parseInt(request.getParameter("id1"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		
		try {
	           
            PreparedStatement pstmt = con.prepareStatement("SELECT balance FROM customer WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

           
            PreparedStatement pstmt1 = con.prepareStatement("SELECT balance FROM customer WHERE id = ?");
            pstmt1.setInt(1, id1);
            ResultSet rs1 = pstmt1.executeQuery();
            
            
           
            if (rs.next() && rs1.next()) {
                int balance1 = rs.getInt("balance");
                int balance2 = rs1.getInt("balance");


              
                balance1 = balance1 + amount;
                balance2 = balance2 +  amount;

               
                PreparedStatement pstmt2 = con.prepareStatement("UPDATE customer SET balance = ? WHERE id = ?");
                pstmt2.setInt(1, balance1);
                pstmt2.setInt(2, id);

                
                PreparedStatement pstmt3 = con.prepareStatement("UPDATE customer SET balance = ? WHERE id = ?");
                pstmt3.setInt(1, balance2);
                pstmt3.setInt(2, id1);

                int i = pstmt2.executeUpdate();
                int j = pstmt3.executeUpdate();

                if (i > 0 && j > 0) {
                    System.out.println("Amount transferred successfully!");
                    System.out.println("Updated Balance of Account ID " + id + ": " + balance1);
                    System.out.println("Updated Balance of Account ID " + id1 + ": " + balance2);
                } else {
                    System.out.println("Transaction failed. Please try again.");
                }

            } else {
                System.out.println("One or both account IDs are invalid.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		response.sendRedirect("index.html");
		doGet(request, response);
	}

}
