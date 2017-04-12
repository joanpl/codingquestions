package com.jlo.coding;

import java.util.Optional;
import java.util.Scanner;

import com.jlo.coding.exception.ProblemInputException;
import com.jlo.coding.exception.UnsolvableProblemException;
import com.jlo.coding.problems.ProblemArraySumFinder;

/**
 * Hello world!
 *
 */
public class App 

{
	
	static ProblemArraySumFinder test1 = new ProblemArraySumFinder<>();	
	
	public static void printMainMenu() {
		System.out.println( "Welcome to App to find a sum in an array" );
        System.out.println( "***********commands*********************" );
        System.out.println( "Exit App [0]" );
        System.out.println( "Solve a Problem [1]" );
        System.out.println( "help [2]" );
	}
	
	public static void printHelpMenu() {
		System.out.println( "On this menu you should only use digits. Please enter a digit for a choice of action" );
		System.out.println( "Welcome to App to find a sum in an array" );
        System.out.println( "***********commands*********************" );
        System.out.println( "Exit App [0]" );
        System.out.println( "Solve a Problem [1]" );
        System.out.println( "help [2]" );
	}
	
	
	public static void mainMenu() {
		 @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in); 
		while(true) {
			printMainMenu();
	        //  System.out.println( "Set Random setup [ 2]" );
		
				//taking value as command line argument.      
		       System.out.printf("Enter a Value:  ");
		       int choice = in.nextInt();
		        switch (choice) {
			      	case 0: 
			      		System.out.println("Bye bye...");
			      		System.exit(0);
			      	case 1: 
			      		problemMenu();
			      		break;
			      	case 2: printHelpMenu();
			      		break;
			        default: System.out.println("Wrong choice");
			        printHelpMenu();
			     }
		}        
  }

       
	

	@SuppressWarnings("unchecked")
	public static void problemMenu() {
		Scanner in = new Scanner(System.in); 
		System.out.println( "This app will find a solution within a list:\n Given an increasingly sorted array and a number s,"
				+ " please find two numbers whose sum is s.If there are multiple pairs with sum s, just output any one of them." );

		int countStupid = 0;
		boolean continueSolving = true;
		while(continueSolving) {
		        System.out.println( "*********** Please insert the size of the list (you can also type 'quit' if you don't know what to do) *********************" );
		        System.out.println( "Enter Value:");
		        try {
				String input  = 	in.next();
				String quit = "quit";
				
				if(	quit.compareTo((String) input) == 0)
				{	
					continueSolving = false;
					System.out.println("returning to main..");
					return;
				}
				
				int size = Integer.parseInt(input);
				System.out.println( "Thanks");
				System.out.println( "Enter a Value for a Solution:");
				input  = 	in.next();
				if(	quit.compareTo((String) input) == 0)
				{	
					continueSolving = false;
					System.out.println("returning to main..");
					return;
				}
				int solution = Integer.parseInt(input);
				System.out.println( "*********** Solving for a list of "+size+" random numbers and a solution of " + solution );
				
				try{
					test1.initializeProblem(test1.generateRandomInput(Optional.of(size)), Optional.ofNullable(solution));	
					test1.solveProblem();
					
					test1.getRandomInput().forEach(item->System.out.print("["+item+"]"));
					System.out.println("SOLUTION");
					System.out.println(test1.getSolution().toString());
					
				} catch (ProblemInputException e) {
						System.out.println(e.getMessage());
				} catch (UnsolvableProblemException e) {
						System.out.println(e.getMessage());
				}
				test1.resetProblem();
				
				
				
			} catch (Exception e) {
				
				System.out.println("Please use digits (e.g. 21) followed by enter!");
				if(countStupid> 2)
					System.out.println("I said... digits only.. meaning.. numbers");
				if (countStupid> 4){
					System.out.println("The force told me you want to return to the main menu");
					continueSolving = false;
				}
				countStupid++;
			}   // make sure it's an int
		}
        
	}
	
	


	public static void randomMenuMenu() {
		System.out.println( "Welcome to Random menu" );
        System.out.println( "***********commands*********************" );
        System.out.println( "Main Menu [0]" );
        System.out.println( "How many times [1]" );
        System.out.println( "Max size of the list [ 2]" );
        System.out.println( "Run app [3]" );
        System.out.println( "Set input values [4]" );
        System.out.println( "help [5]" );
        
	}
	
	
	
	
    public static void main( String[] args )
    {
    	mainMenu();
//        
//        int count = 10;
//		while(count>0){
//			
//			int listSize = ProblemArraySumFinder.randInt(-1000, 5000);
//			
//			int result = ProblemArraySumFinder.randInt(-500, 2500);
//			
//			try{
//			test1.initializeProblem(test1.generateRandomInput(Optional.of(listSize)), Optional.ofNullable(result));	
//			test1.solveProblem();
//			} catch (ProblemInputException e) {
//				System.out.println(e.getMessage());
//			}catch (UnsolvableProblemException e) {
//				System.out.println(e.getMessage());
//			}
//			test1.getRandomInput().forEach(item->System.out.print("["+item+"]"));
//			System.out.println("SOLUTION");
//			System.out.println(test1.getSolution().toString());
//			
//			count--;
//		}
    }
}
