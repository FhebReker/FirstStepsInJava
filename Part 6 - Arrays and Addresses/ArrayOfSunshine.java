/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-12-20
 @Description: Makes 2 arrays of 20 random numbers, then does the following:
        multiplies numbers between the arrays, replaces odd numbers, 
        adds numbers between the arrays, finds average of the arrays, 
        searches for a specific number, inverts arrays.

***********************************************
*/

import java.util.*;

public class ArrayOfSunshine {
    public static void main(String[] args) {
        // initializes scanner, then arrays using randomFillArray
        Scanner input = new Scanner (System.in);
        int[] list1 = new int[20];
        int[] list2 = new int[20];
        list1 = randomFillArray(list1);
        list2 = randomFillArray(list2);
        
        // prints initial arrays
        printArray(list1, 5);
        printArray(list2, 4);
        
        // multiplies array 1 by index number
        multiplyArray(list1, list2);
        printArray(list2, 4);
        
        // replaces odd numbers in list2
        list2 = replaceOddNumber(list2);
        printArray(list2, 4);
        
        // adds remaining numbers from list2 to list 1
        list1 = addElements(list1, list2);
        printArray(list1, 5);
        
        // shows average of both arrays
        averageOfArray(list1);
        averageOfArray(list2);
        
        // searches for a number in list1
        searchArray(list1, input);
        
        // inverses list1
        inverseArray(list1, list2);
        printArray(list2, 5);
        
        // closes scanner
        input.close();
    }
	// press enter to continue //
	public static void pressAnyKeyToContinue() {
		System.out.println("Press enter to continue...");
		try {
			System.in.read();
			System.in.skip(System.in.available());
		} catch (Exception e) {
		}
	}
	// prints array with columns //
	public static void printArray(int [] array, int columns) {
		for (int i = 0; i < array.length; i += columns) {
			for (int j = 0;j < columns; j++) {
				System.out.print(array[ i + j ] + "\t" );
			}
			System.out.print("\n");
		}
		pressAnyKeyToContinue();
	}
    // fills array with random numbers from 1 to 100 //
    public static int[] randomFillArray(int[] array){
		for (int i=0; i < array.length; i++){
		    array[i] = (int)(Math.random()*100 + 1);
		}
		return array;
    }
    // multiplies array by index number //
    public static int[] multiplyArray(int[] array1, int[] array2){
        for(int i = 0; i < array1.length; i++){
            array2[i] = array1[i]*i;
        }
        return array2;
    }
    // replaces odd numbers in the array with 0 //
    public static int[] replaceOddNumber(int[] array){
        for(int i = 0; i < array.length; i++){
            if (array[i] % 2 == 1)
                array[i] = 0;
        }
        return array;
    }
    // adds numbers from the second array into the first //
    public static int[] addElements (int[] array1, int[] array2){
        for (int i = 0; i < array1.length; i++){
            array1[i] += array2[i];
        }
        return array1;
    }
    // gives average of the array //
    public static void averageOfArray(int[] array){
        double temp = 0;
        for (int i = 0; i < array.length; i++)
            temp += array[i];
        temp /= (double) array.length;
        System.out.println("The average length of this array is " + temp);
        System.out.println();
    }
    // reverses array //
    public static int[] inverseArray(int[] array1, int[] array2){
        for(int i = (array1.length - 1), j = 0; j < array1.length; i--, j++)
            array2[j] = array1[i];
        return array1;
    }
    // searches array for a number //
    public static void searchArray(int[] array, Scanner scanner){
        System.out.println("Please enter a value to search for: ");
        boolean readNumber = false;
        int readNum = scanner.nextInt();
        for(int i = 0; i < array.length; i++){
            if (readNum == array[i]){
                System.out.println("Appears at element " + (i + 1));
                readNumber = true;
            }
        }
        if (readNumber == false)
            System.out.println("Does not appear in array");
        System.out.println();
    }
}
