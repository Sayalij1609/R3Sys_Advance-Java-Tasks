package Bank_application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Transfer {

    Scanner sc = new Scanner(System.in);

    void transfer_amount()throws InsufficientBalance {

        Connection con = DBConnect.connect();

        System.out.println("Enter your Account id: ");
        int id1 = sc.nextInt();

        System.out.println("Enter Account id of the other Account: ");
        int id2 = sc.nextInt();

        System.out.println("Enter Amount for transfer: ");
        int amount = sc.nextInt();

        try {
           
            PreparedStatement pstmt = con.prepareStatement("SELECT balance FROM customer WHERE id = ?");
            pstmt.setInt(1, id1);
            ResultSet rs = pstmt.executeQuery();

           
            PreparedStatement pstmt1 = con.prepareStatement("SELECT balance FROM customer WHERE id = ?");
            pstmt1.setInt(1, id2);
            ResultSet rs1 = pstmt1.executeQuery();
            
            
           
            if (rs.next() && rs1.next()) {
                int balance1 = rs.getInt("balance");
                int balance2 = rs1.getInt("balance");

                if (balance1 < amount) {
                	
         			   throw new InsufficientBalance ("Insufficient Balance in Account....Transfer is not Possible ");
         		   
                }

                System.out.println("Current Balance of Account ID " + id1 + ": " + balance1);
                System.out.println("Current Balance of Account ID " + id2 + ": " + balance2);

              
                balance1 = balance1 + amount;
                balance2 = balance2 +  amount;

               
                PreparedStatement pstmt2 = con.prepareStatement("UPDATE customer SET balance = ? WHERE id = ?");
                pstmt2.setInt(1, balance1);
                pstmt2.setInt(2, id1);

                
                PreparedStatement pstmt3 = con.prepareStatement("UPDATE customer SET balance = ? WHERE id = ?");
                pstmt3.setInt(1, balance2);
                pstmt3.setInt(2, id2);

                int i = pstmt2.executeUpdate();
                int j = pstmt3.executeUpdate();

                if (i > 0 && j > 0) {
                    System.out.println("Amount transferred successfully!");
                    System.out.println("Updated Balance of Account ID " + id1 + ": " + balance1);
                    System.out.println("Updated Balance of Account ID " + id2 + ": " + balance2);
                } else {
                    System.out.println("Transaction failed. Please try again.");
                }

            } else {
                System.out.println("One or both account IDs are invalid.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
