package banking_application;

import java.util.Scanner;
import java.util.scanner;

public class BankingApplication {
	
	public static void main(String[] args) {
		
		BankAccount obj1 = new BankAccount("Jerry Zhu", "jryzu0216");
		obj1.showMenu();
	}

}

class BankAccount
{ 
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname, String cid)
	{
		customerName = cname;
		customerId = cid;
	}
	
	void deposit(int amount)
	{
		if (amount != 0)
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount)
	{
		if (amount != 0)
		{
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction()
	{
		if (previousTransaction > 0)
		{
			System.out.println("Deposited: " + previousTransaction);
		}
		else if (previousTransaction < 0)
		{
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else 
		{
			System.out.println("No transaction occurred");
		}
	}
	
	void showMenu()
	{
		char option = '\0';
		Scanner scanner = new Scanner(System.in);

		
		System.out.println("Welcome " + customerName);
		System.out.println("Your customer ID is " + customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit Amount");
		System.out.println("C. Withdraw Amount");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do
		{
			System.out.println("==========================================================");
			System.out.println("Please choose one of the options above:");
			System.out.println("==========================================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			
			case 'A':
				System.out.println(+ balance);
				break;
			
				
			case 'B':
				System.out.println("Please enter the amount you would like to deposit:");
				int amount = scanner.nextInt();
				deposit(amount);
				break;
				
			case 'C':
				System.out.println("Please enter the amount you would like to withdraw:");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				break;
			
			case 'D':
				getPreviousTransaction();
				break;
				
			default:
				System.out.println("Invalid option! Please enter again.");
				break;
			}
		}while (option != 'E');
			
		System.out.println("Thank you for using our services and have a nice day.");
	}
	
	
}