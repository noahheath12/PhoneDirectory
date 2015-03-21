package com.noahheath.howardu.assignments;

import java.io.IOException;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean restart = true;
		PhoneDirectory myPhoneBook = new PhoneDirectory();
		int option = 0;
		do{
			String input="", name="", number="";
			System.out.println("Please Choose an Option From the Menu Below");
			System.out.println("1: Search For a Phone Number in the Directory");
			System.out.println("2: Add an Entry to the Directory(Must write changes after)");
			System.out.println("3: Delete an Entry from the Directory(Must write changes after)");
			System.out.println("4: Edit a Phone Number in the Directory(Must write changes after)");
			System.out.println("5: Write Changes to the Directory");
			System.out.println("6: Exit the Program");
			System.out.print("Choice: ");
			Scanner input1 = new Scanner(System.in);
			while(!input1.hasNextInt()){
				System.out.print("Bad input. Try again: ");
				input1.next();
			}
			option = input1.nextInt();
			switch(option){
				case 1:  SearchForNumber(input, myPhoneBook);
					break;
				case 2: AddorChangePhoneBook(myPhoneBook, name, number);
					break;
				case 3: DeleteEntry(name, myPhoneBook);
					break;
				case 4: AddorChangePhoneBook(myPhoneBook, name, number);
					break;
				case 5: try {
					WriteChanges(myPhoneBook);
				} catch (IOException e) {
					System.err.println("Unable to save file");
				}
					break;
				case 6: restart = false;
			}
		}while(restart);
		
		
		System.out.println("Goodbye!");
	}
	
	/**
	 * PreCondition: Directory must be initialized.
	 * PostCondition: returns a phone number.
	 */
	public static void SearchForNumber(String anInput, PhoneDirectory myDirectory){
		System.out.print("Please enter a name to search for: ");
		Scanner in = new Scanner(System.in);
		anInput = in.nextLine();
		if(myDirectory.lookup(anInput) == null)
			System.out.println("Entry does not exist");
		else{
			System.out.println("Number: " + myDirectory.lookup(anInput));
		}
	}
	
	/**
	 * PreCondition: Directory must be initialized
	 * PostCondition: Creates a new entry in the phone book if it does not exist.
	 * 				  Changes a current entry if it exists
	 * 				  
	 */
	public static void AddorChangePhoneBook(PhoneDirectory myDirectory, String myName, String myNumber){
		System.out.println("Enter a name: ");
		Scanner in = new Scanner(System.in);
		myName = in.nextLine();
		if(myDirectory.findName(myName)){
			System.out.println("Entry exists.");
			myDirectory.deleteEntry(myName);
			System.out.print("Enter new number: ");
			in = new Scanner(System.in);
			myNumber = in.nextLine() + "\n";
			myDirectory.AddOrChangeEntry(myName, myNumber);
			System.out.println("Entry Changed!");
		}
		else{
			System.out.print("Number(XXX-XXX-XXXX): ");
			in = new Scanner(System.in);
			myNumber = in.nextLine() + "\n";
			myDirectory.AddOrChangeEntry(myName, myNumber);
			System.out.println("Entry Added!");
		}
	}
	
	/**
	 * PreCondition: Directory must be initialized.
	 * PostCondition: Deletes an entry from the phone book.
	 */
	public static void DeleteEntry(String myName, PhoneDirectory myDirectory){
		System.out.println("Please enter the name of the entry to be deleted.");
		System.out.print("Name: ");
		Scanner in = new Scanner(System.in);
		myName = in.nextLine();
		myDirectory.deleteEntry(myName);
		System.out.println("Entry Deleted\n");
	}
	
	/**
	 * PreCondition: Directory must be initialized
	 * PostCondition: Changes made to the phone book are saved. 
	 */
	public static void WriteChanges(PhoneDirectory myDirectory) throws IOException{
		if(myDirectory.changedStatus == true){
			myDirectory.write();
			myDirectory.changedStatus = false;
		}
		else{
			System.out.println("File Was Not Changed");
		}
	}
	
}
