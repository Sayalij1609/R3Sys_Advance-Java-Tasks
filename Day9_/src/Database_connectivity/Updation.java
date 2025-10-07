package Database_connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Updation {
    
	Scanner sc = new Scanner(System.in);
	
	void insertion(){
		
		Connection con = DBConnection.connect();
		
		int prn = 0;
		System.out.println("Enter Student Name : ");
		String name = sc.nextLine();
		System.out.println("Enter Email : ");
		String email = sc.nextLine();
		System.out.println("Enter Password : ");
		String password = sc.nextLine();
		System.out.println("Enter Branch name : ");
		String bname = sc.nextLine();
		System.out.println("Enter City name : ");
		String cname= sc.nextLine();
		
		
		try {
			
			
			PreparedStatement pstmt = con.prepareStatement("Insert into personal_info values (?,?,?,?,?,?)");
			
			pstmt.setInt(1,0 );
			pstmt.setString(2 ,name );
			pstmt.setString(3 ,email );
			pstmt.setString(4,password);
			pstmt.setString(5,bname);
			pstmt.setString(6,cname );
			
			int i = pstmt.executeUpdate();
			
			if(i>0){
				System.out.println("Row Updated.....");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
