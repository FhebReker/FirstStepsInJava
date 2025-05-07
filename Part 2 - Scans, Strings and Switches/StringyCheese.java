/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-10-02
 @Description: Inputs name, separates it into title, first name and last name and then prints out variations of the name.

***********************************************
*/


import java.util.Scanner;

class stringyCheese{
	public static void main(String[] args) {
		// Scanner 
		java.util.Scanner UserInput = new Scanner(System.in);
		System.out.println("Enter your title and full name: ");
		String name = UserInput.nextLine();
		System.out.println();

// Using period for key
		String keyOne = ".";
		int index = name.indexOf(keyOne);
		
		// Title and name separated 
		String title = name.substring(0, index + 1) + " ";
		String restOfName = name.substring(index+2);
		
		// Using space as key 
		String keyTwo = " ";
		int secondIndex = restOfName.indexOf(keyTwo);
		
		// Separating first and last names
		String firstName = restOfName.substring(0, secondIndex);
		String lastName = restOfName.substring(secondIndex + 1);
		
		// Printing out names
		System.out.println(title + restOfName);
		System.out.println(firstName + " " + lastName);
		System.out.println(lastName +", " + firstName);
		System.out.println(title + lastName);
		System.out.println(lastName + ", " + firstName.charAt(0));
		
		// Closes scanner
		UserInput.close();		
	}	
} // Closes class and main
