package Bank_application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {
	
	
Scanner sc = new Scanner(System.in);
	
	void insertion(){
		
		Connection con = DBConnect.connect();
		
		int id = 0;
		System.out.println("Enter name : ");
		String name = sc.nextLine();
		System.out.println("Enter Email : ");
		String email = sc.nextLine();
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		System.out.println("Enter your balance : ");
		int balance  = sc.nextInt();
		
		
		try {
			
			
			PreparedStatement pstmt = con.prepareStatement("Insert into customer values (?,?,?,?,?)");
			
			pstmt.setInt(1,0 );
			pstmt.setString(2 ,name );
			pstmt.setString(3 ,email );
			pstmt.setString(4,password);
			pstmt.setInt(5,balance);
			
			
			int i = pstmt.executeUpdate();
			
			if(i>0)
			{
				System.out.println("Account Created Successfully!!");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
