/**
***********************************************
 @Author: Fardin Abbassi
 @Last Modified: 2023-01-25
 @Description: Creates a 20-question questionaire on various subjects. If 3 questions are answered incorrectly, the game is over.

***********************************************
*/
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
  // file, scanner and BufferedReader initialized
  File qna = new File("QnA.txt");
  Scanner scan = new Scanner(System.in);
  BufferedReader br = null;
  try {
    // declares br, fileInfo array, question array, response array, answerkey array
    br = new BufferedReader(new FileReader (qna));
    String[] questions = new String[21]; 
    String[] responses = new String[80];
    char[] answers = new char[80];
    String[] internalInfo = new String[101];

    // declares questionCount, responseCount, chances
    int questionCount = 0; 
    int responseCount = 0;
    int chances = 3;

    // reads first line of file
    internalInfo[0] = br.readLine();

    // for loop: loops through file information until answer array has all the answers, response array has all the responses and question array has all the questions //
    for (int i = 0; internalInfo[i] != null; i++, internalInfo[i] = br.readLine()){
      if (internalInfo[i].charAt(0) == 'Q'){
        questions[questionCount] = internalInfo[i].substring(2);
        answers[questionCount] = internalInfo[i].charAt(1);
        questionCount++;
      }
      else{
        responses[responseCount] = internalInfo[i];
        responseCount++;
      }
    } // end for loop
    
    // introduces/starts the game
    System.out.println("Welcome to Win Big or Go Home!\n\nThis questionaire has 20 questions \nYou only have 3 chances to get a question wrong\nAre you ready to win?");
    pressToContinue();
    int moneyAccumulated = 0;

    // for loop: loops through each question; for each question answered correctly, money is won, otherwise a chance is lost. Ends when all questions are asked or chances are depleted
    for (int currentQuestion = 0; questions[currentQuestion] != null && chances > 0; currentQuestion++){
      boolean answer = nextQuestion(questions, responses, answers, currentQuestion, scan);
      if (answer == false)
        chances -= 1; 
      else
        moneyAccumulated += 5000;
      System.out.println("Chances left: " + chances);
      System.out.println("Money gained: $" + moneyAccumulated);
      pressToContinue();
    } // end for loop
    // if chances are left by the end of the loop, print win screen. Otherwise, print loss screen.
    if (chances > 0){
      System.out.println("You won! \nPrize Money: $" + moneyAccumulated);
      System.out.println("I knew you had it in you! Great job!");
    }
    else{
      System.out.println("Oh no, you lost! \nBetter luck next time!");
    }
  } // end try
  catch (IOException e) {
    e.printStackTrace();
  }
  } // end main
/*
* Method Name: nextQuestion
*Author: Fardin Abbassi
* Creation Date; January 19, 2023
* Modified Date: January 24, 2023
*Description: Loads the next question and responses. Also takes answer from user.
* @Parameters: (String[] questions, String[] responses, char[] answers, int questionNumber, Scanner scan)
* @Return Value: boolean
* Data Type: String[], char[], int, Scanner
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
  public static boolean nextQuestion(String[] questions, String[] responses, char[] answers, int questionNumber, Scanner scan){
   // prints question
    System.out.print("Question #" + (questionNumber + 1) + ": ");
    System.out.println(questions[questionNumber]);

    // declares question responses 
    String[] questionResponses = {responses[(4*questionNumber)], responses[1+(4*questionNumber)], responses[2+(4*questionNumber)], responses[3+(4*questionNumber)]};

    // prints question responses
    System.out.println(questionResponses[0]);
    System.out.println(questionResponses[1]);
    System.out.println(questionResponses[2]);
    System.out.println(questionResponses[3]);

    // declares guess; takes user input as a guess
    char guess = scan.next().charAt(0);

    if (guess == answers[questionNumber]){
      System.out.println("You got it right!");
      return true; 
    }
    // if the guess is incorrect, display correct answer
    else{
      System.out.println("You got it wrong!");
      System.out.print("Correct answer: ");
      for (int i = 0; i < questionResponses.length; i++){
        if (questionResponses[i].charAt(0) == answers[questionNumber])
          System.out.println(questionResponses[i]);
      }
      return false;
    }
  }
/*
* Method Name: nextQuestion
*Author: Fardin Abbassi
* Creation Date; January 20, 2023
* Modified Date: January 20, 2023
*Description: Gets the user to press enter before moving on to the next part of the code
* @Parameters: n/a
* @Return Value: void
* Data Type: n/a
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
	public static void pressToContinue() {
		System.out.println("Press enter to continue...");
		try {
			System.in.read();
			System.in.skip(System.in.available());
		} catch (Exception e) {
		}
	}
}
