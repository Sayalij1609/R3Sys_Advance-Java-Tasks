package Bank_application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Withdraw {
     
Scanner sc = new Scanner(System.in);
	
	void withdraw_amount ()throws InsufficientBalance{
		
		Connection con = DBConnect.connect();
		
		int amount ; 
		System.out.println("Enter Amount Withdraw : ");
		amount = sc.nextInt();
		System.out.println("Enter Account id : ");
		int id = sc.nextInt();
		
		try {
			PreparedStatement pstmt = con.prepareStatement("Select balance from customer where id= ?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				
		     int balance = rs.getInt(1);
		     
		     if (balance < amount) {
             	
   			   throw new InsufficientBalance ("Insufficient Balance in Account....Withdraw is not Possible ");
   		   
             }
		     
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
			
			e.printStackTrace();
		}
	
	}
}
