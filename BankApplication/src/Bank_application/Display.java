package Bank_application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Display {
	
void display(){
		
	Scanner sc = new Scanner(System.in);
	
		Connection con = DBConnect.connect();
		
		
		try {
			
			System.out.println("Enter Account id : ");
			int id = sc.nextInt();
			
			PreparedStatement pstmt = con.prepareStatement("Select * from customer where id = ?");
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				System.out.println("\nAccount ID : "+rs.getInt(1));
				System.out.println("Account Holder Name : "+rs.getString(2));
				System.out.println("Customer Email : "+rs.getString(3));
				System.out.println("Password :"+rs.getString(4));
				System.out.println("Balance : "+rs.getInt(5));
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
     }


}
