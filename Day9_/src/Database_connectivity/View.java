package Database_connectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class View {
	
	void display(){
		
		Connection con = DBConnection.connect();
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from personal_info");
			
			while(rs.next()){
				
				System.out.println("\nStudent PRN : "+rs.getInt(1));
				System.out.println("Student Name : "+rs.getString(2));
				System.out.println("Student Email : "+rs.getString(3));
				System.out.println("Student Password :"+rs.getString(4));
				System.out.println("Student Branch : "+rs.getString(5));
				System.out.println("Student City : "+rs.getString(6));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
