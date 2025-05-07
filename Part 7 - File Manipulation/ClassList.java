/**
***********************************************
 @Author: Fardin Abbassi
 @Last Modified: 2023-01-20
 @Description: Looks through a file of students and grades in a class. Either prints out student names, student grades, a specific student's grade, the student with the highest grade, the student with the lowest mark or the class average. 

***********************************************
*/

import java.io.*;
import java.util.*;

class ClassList {
  public static void main(String[] args) //throws Exception
  {
    File file = new File("student.txt");
    File curvedFile = new File ("student2.txt");
    Scanner scan = new Scanner(System.in);
    BufferedReader br = null;
    BufferedWriter bw = null;
    try {
      br = new BufferedReader(new FileReader(file));
      bw = new BufferedWriter(new FileWriter(curvedFile));
      String[] names = new String[33]; String[] fileInfo = new String[65];
      double[] average = new double[33];
      int fileCount = 0; int namesCount = 0; int averageCount = 0;
      fileInfo[fileCount] = br.readLine();
      do {
        if (isNumeric(fileInfo[fileCount]) == true) {
          average[averageCount] = Double.parseDouble(fileInfo[fileCount]);
          averageCount += 1;
}
        else{
          names[namesCount] = fileInfo[fileCount];
          namesCount += 1;
}
        fileCount++;          
        fileInfo[fileCount] = br.readLine();
      } while (fileInfo[fileCount] != null); // end while

      System.out.println("What do you want to do? \nA. Print out student names \nB. Print out student names\nC. Find a student's grade \nD. Find the highest-scoring student \nE. Find the lowest-scoring student \nF. Find the class average \nG. Bell Curve \nH. Exit code");
      char option = scan.next().charAt(0);
      while (option != 'H'){
        System.out.println();
        switch (option){
          case 'A':
            printTable(names); break;
          case 'B':
            printTable(average); break;
          case 'C':
            System.out.println("Which student? Type in the student's index on the list \n(Refer to the student names printout)");
            String namesAtIndex = scan.next();
            while (isNumeric(namesAtIndex) == false) {
              System.out.println("Use a number this time!");
              System.out.println("Which student? Type in the student's index on the list \n(Refer to the student names printout)");
            } // end while
            int namesIndex = Integer.parseInt(namesAtIndex);
            searchForStudent(names[namesIndex], names, average);
            break;
          case 'D':
            highNum(names, average); break;
          case 'E':
            lowNum(names, average); break;
          case 'F':
            classAverage(average); break;
          case 'G':
            System.out.println("What number would you like to curve by?");
            String curveScan = scan.next();
            while (isNumeric(curveScan) == false) {
              System.out.println("Use a number this time!");
              System.out.println("What number would you like to curve by?");
              curveScan = scan.next();
            } // end while
            int curve = Integer.parseInt(curveScan);
            bellCurve(names, average, curve, curvedFile, scan, bw);
            break;          
        }
        System.out.println();
        System.out.println("What do you want to do? \nA. Print out student names \nB. Print out student names\nC. Find a student's grade \nD. Find the highest-scoring student \nE. Find the lowest-scoring student \nF. Find the class average \nG. Bell Curve \nH. Exit code");
        option = scan.next().charAt(0);
      } // end while
      System.out.println();
      System.out.println("Thank you, have a nice day!");
      br.close();
    }   // end try
    catch (IOException e) {
        e.printStackTrace();
      }
  } // end main
  
/*
* Method Name: isNumeric
*Author: Fardin Abbassi
* Creation Date; January 10, 2023
* Modified Date: January 11, 2023
*Description: Checks if a string can be parsed into a number
* @Parameters: String strNum
* @Return Value: boolean
* Data Type: String
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
/*
* Method Name: printTable
*Author: Fardin Abbassi
* Creation Date; January 11, 2023
* Modified Date: January 12, 2023
*Description: Prints a table using a string array
* @Parameters: String[] list
* @Return Value: void
* Data Type: String[]
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
  public static void printTable(String[] list){
      for (int i = 0; list[i] != null; i += 4) {
  			for (int j = 0;j < 4; j++) {
  				  System.out.print(list[ i + j ] + "\t" );
  			} // end row for loop
  			System.out.print("\n");
		} // end column for loop
  }
/*
* Method Name: printTable
*Author: Fardin Abbassi
* Creation Date; January 11, 2023
* Modified Date: January 12, 2023
*Description: Prints a table using a double array
* @Parameters: double[] list
* @Return Value: void
* Data Type: double[]
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
  public static void printTable(double[] list){
      for (int i = 0; list[i] != 0.0; i += 4) {
  			for (int j = 0;j < 4; j++) {
  				  System.out.print(list[ i + j ] + "\t" );
  			} // end row for loop 
  			System.out.print("\n");
		} // end column for loop
  }
/*
* Method Name: searchForStudent
*Author: Fardin Abbassi
* Creation Date; January 13, 2023
* Modified Date: January 13, 2023
*Description: Searches for a student's grade
* @Parameters: String name, String[] listOfNames, double[] grades
* @Return Value: void
* Data Type: String[], String, double[]
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
  public static void searchForStudent(String name, String[] listOfNames, double[] grades){
    for (int i = 0; listOfNames[i] != null; i++){
      if (listOfNames[i] == name){
        System.out.println(name + "'s grade is " + grades[i]);
      }
    } // end for loop
  }
/*
* Method Name: highNum
*Author: Fardin Abbassi
* Creation Date; January 14, 2023
* Modified Date: January 14, 2023
*Description: Searches for the highest grade in the class
* @Parameters: String[] names, double[] marks
* @Return Value: void
* Data Type: String[], double[]
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
  public static void highNum (String[] names, double[] marks){
      int maxIndex = 0;
		for (int i = 1; i < names.length && names[i] != null; i++) {
			if (marks[i] > marks[maxIndex]) {
				maxIndex = i;
			}
		} // end for loop
    System.out.println(names[maxIndex] + " has the highest mark of " + marks[maxIndex]);

}
/*
* Method Name: lowNum
*Author: Fardin Abbassi
* Creation Date; January 14, 2023
* Modified Date: January 14, 2023
*Description: Searches for the lowest grade in the class
* @Parameters: String[] names, double[] marks
* @Return Value: void
* Data Type: String[], double[]
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
  public static void lowNum (String[] names, double[] marks){
      int minIndex = 0;
		for (int i = 1; i < names.length && names[i] != null; i++) {
			if (marks[i] < marks[minIndex]) {
				minIndex = i;
			}
		} // end for loop
    System.out.println(names[minIndex] + " has the lowest mark of " + marks[minIndex]);

}
/*
* Method Name: highNum
*Author: Fardin Abbassi
* Creation Date; January 14, 2023
* Modified Date: January 14, 2023
*Description: Displays the class average
* @Parameters: double[] marks
* @Return Value: void
* Data Type: double[]
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
  public static void classAverage (double[] marks){
    double total = 0.0;
    for (int i = 0; i < marks.length && marks[i] != 0.0; i++){
      total += marks[i];
    } // end for loop
    total = Math.round((total / (marks.length - 1)) * 10) / 10.0;
    System.out.println("Class average is " + total);
  }
/*
* Method Name: bellCurve
*Author: Fardin Abbassi
* Creation Date; January 15, 2023
* Modified Date: January 18, 2023
*Description: Creates a bell curve scenario, then asks the user if they want to save it.
* @Parameters: String[] names, double[] marks, int curvingBy, File bellCurveFile, Scanner scan, BufferedWriter bw
* @Return Value: void
* Data Type: String[], double[], int, File, Scanner, BufferedWriter
* Dependencies: n/a
*Throws/Exceptions: IOException
*/
  public static void bellCurve (String[] names, double[] marks, int curvingBy, File bellCurveFile, Scanner scan, BufferedWriter bw) throws IOException {
    
    double[] curvedMarks = new double[marks.length];

    // loops through marks to get curved marks
    for (int i = 0; i < marks.length; i++){
      curvedMarks[i] = Math.round((marks[i] * (1 + (curvingBy / 100.0))) * 10);
      curvedMarks[i] /= 10;
      if (curvedMarks[i] >= 100.0) {
        curvedMarks[i] = 100.0;
      } 
    } // end for loop
    printTable(curvedMarks);
    System.out.println("Would you like to save this data? \n'Y' for yes, 'N' for no");
    char choice = scan.next().charAt(0);
    if (choice == 'Y'){
      // writes over old marks
      for (int i = 0; i < marks.length; i++){
        marks[i] = curvedMarks[i];
        String line = ((int)curvedMarks[i]) + "." + (int)((curvedMarks[i] - (int)curvedMarks[i]) * 10);
        bw.write(line);
        bw.newLine();
      } // end for loop
    }
    else{
      System.out.println("Remember, if you want to select a different curve, choose 'Bell Curve' and pick a different number.");
    }
  }
}
