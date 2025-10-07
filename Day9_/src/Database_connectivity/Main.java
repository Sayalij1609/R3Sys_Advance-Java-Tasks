package Database_connectivity;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice , ch ;
		do{
			System.out.println("-----------------MENU----------------");
			System.out.println("\n1.Insert The Details \n2.View the details");

			System.out.println("Enter Your Choice : ");
			choice = sc.nextInt();
			
			switch(choice){
			
			case 1 : 
				Updation up = new Updation();
				up.insertion();
			
			case 2 : 
				View ve = new View();
				ve.display();
				
			default : 
				System.out.println("Invalid Input...");
			}
			
			
			System.out.println("\nDo you want to repeat the Process ??  \nPress 1 : If Yes  \nPress 2 : If No");
			ch = sc.nextInt();
			
		}while(ch==1);
		
		
	}

}
