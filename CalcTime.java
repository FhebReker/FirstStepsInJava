/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-10-28
 @Description: Inputs 1 or 2 numbers and an operator to calculate an expression. The result can be modified after as well.

***********************************************
*/
import java.util.Scanner;

public class CalcTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // values
        double firstNum, secondNum, result;
        String firstString, secondString, thirdString;
        char operator;
        boolean resultRecieved;
        
        // sets result to 0 and resultRecieved 
        //to false so it runs the first time
        result = 0;
        resultRecieved = false;
        
        // loop
        while (true){
            
            // operator/number grabber
            firstString = scanner.nextLine();
            secondString = scanner.nextLine();

            // checks if operator in first line and if there's a result
            if ((firstString.charAt(0) == '+' || firstString.charAt(0) == '-' || firstString.charAt(0) == '*' || firstString.charAt(0) == '/' ) && resultRecieved == true){
                operator = firstString.charAt(0);
                firstNum = result;
                secondNum = Integer.parseInt(secondString);
            }
            
            // first/new statement 
            else{
                operator = secondString.charAt(0);
                thirdString = scanner.nextLine();
                firstNum = Integer.parseInt(firstString);
                secondNum = Integer.parseInt(thirdString);
            }
            System.out.println();
            
            // switches between operators, gets result
            switch(operator){
                case '+':
                    result = firstNum + secondNum; System.out.println(firstNum + " + " + secondNum + " = " + result); resultRecieved = true; break;
                case '-':
                    result = firstNum - secondNum; System.out.println(firstNum + " - " + secondNum + " = " + result); resultRecieved = true; break;
                case '*':
                    result = firstNum * secondNum; System.out.println(firstNum + " * " + secondNum + " = " + result); resultRecieved = true; break;
                case '/':
                    result = firstNum / secondNum; System.out.println(firstNum + " / " + secondNum + " = " + result); resultRecieved = true; break;
                default: System.out.println("Operator invalid!"); break;
            }
            System.out.println();
        }
        }
}
