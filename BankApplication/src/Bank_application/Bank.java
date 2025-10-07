package Bank_application;

import java.util.Scanner;

public class Bank {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice; {
			
			System.out.println("\n-----------------MENU----------------");
			System.out.println("\n1.Create Account \n2.Deposite Amount \n3.Withdraw amount \n4.Transfer Amount \n5.View the details");

			System.out.println("Enter Your Choice : ");
			choice = sc.nextInt();
			
			switch(choice){
			
			case 1 : 
				Account a = new Account();
				a.insertion();
				break;
			
			case 2 : 
				Deposite de = new Deposite();
				break;
				
				
			case 3 :
				Withdraw w = new Withdraw();
				try {
					w.withdraw_amount();
				} catch (InsufficientBalance e1) {
					
					System.out.println(e1.getMessage());
				}
				break;
				
				
			case 4: 
				Transfer t=new Transfer();
				try {
					t.transfer_amount();
				} catch (InsufficientBalance e) {
					System.out.println(e.getMessage());
				}
				break;
				
		
			case 5 : 
				Display d = new Display();
				d.display();
				break;
				
				
			default : 
				System.out.println("Invalid Input...");
			}
			
			
		}	
		
		
		
	}
	
	
}
