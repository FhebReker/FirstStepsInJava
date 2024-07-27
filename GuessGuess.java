/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-11-09
 @Description: Makes user guess a random number between 1 and 20

***********************************************
*/
import java.util.Scanner;

public class GuessGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randNum = (int)(20*Math.random()+1);
        guessingGame(randNum);
    }

/*
* Method Name: guessingGame
*Author: Fardin Abbassi
* Creation Date; NOVEMBER 08, 2022
* Modified Date: NOVEMBER 09, 2022
*Description: Creates the guessing game using a random number. 
* @Parameters: (int number)
* @Return Value: n/a
* Data Type: Integer
* Dependencies: n/a
*Throws/Exceptions: Input mismatch if input is not an integer.
*/
    public static void guessingGame (int number) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect = false;
        int guesses, guess;
        
        System.out.println("Pick a number from 1 to 20");
        for (guesses = 5; guesses > 0; guesses--){
            guess = scanner.nextInt();
            if (guess == number){
                isCorrect = true;
                System.out.println("Awesome, you got it!");
                System.out.println("Number of tries took: " + (0 - guesses + 6));
                break;
            }
            else if (guess > number && guess <= 20)
                System.out.println("Too high!");
            else if (guess < number && guess >= 0)
                System.out.println("Too low!");
            else
                System.out.println("Invalid, try again!");
            System.out.println();
            }
        if (guesses == 0 && isCorrect == false){
            System.out.println("Game Over! \nActual Number: " + number);
        }
    }
}
