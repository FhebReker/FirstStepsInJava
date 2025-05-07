/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-11-15
 @Description: Creates a game of Pig between 2 players, ends when one player reaches 100 first.

***********************************************
*/

import java.util.Scanner;

public class PigGame {
    /*
    * Method Name: printout
    * Author: Fardin Abbassi
    * Creation Date; November 15, 2022
    * Modified Date: November 15, 2022
    * Description: Prints out names of players of the game.
    * @Parameters: int playerNum
    * @Return Value: return player    
    * Data Type: String
    * Dependencies: n/a
    *Throws/Exceptions: n/a
    */
    public static String printout(int playerNum){
        Scanner s = new Scanner(System.in);
        // scans for player name
        System.out.println("Enter player "+ playerNum + "'s name here: ");
        String player = s.nextLine();
        return player;
    }
    /*
    * Method Name: whoGotNext
    * Author: Fardin Abbassi
    * Creation Date; November 15, 2022
    * Modified Date: November 15, 2022
    * Description: Rolls dice and updates player score. 
    * @Parameters: String player, int playerTotal
    * @Return Value: return total
    * Data Type: Integer
    * Dependencies: Math
    *Throws/Exceptions: Exception when char finishTurn is empty
    */
    public static int whoGotNext(String player, int playerTotal){
        Scanner s = new Scanner(System.in);
        String finishedTurn;
        int total, diceRoll;
        total = 0;  diceRoll = 0;
        char finishTurn = 'Y';
        while (finishTurn == 'Y'){
            diceRoll = (int)(6*Math.random()+1);
            // player turn
                System.out.println(player + "'s Turn!");
                System.out.println(player + " rolled a " + diceRoll);
                System.out.println("Rolled total: " + (total+diceRoll) + "\nPotential Total: " + (diceRoll+total+playerTotal));
                // if rolled a 1, switches turn
                if (diceRoll == 1){
                    System.out.println("Sorry, no points earned this round!");
                    total = 0;
                    System.out.println("You still need " + (100 - (total+playerTotal)) + " points to win the game!");
                    return total;
                }
                // if rolling again, increase temp score
                total += diceRoll;
                System.out.println("Roll again? (Y or N)");
                finishedTurn = s.nextLine();
                finishTurn = finishedTurn.charAt(0);
            }
        // if holding, add to player score
        System.out.println("You still need " + (100 - (total+playerTotal)) + " points to win the game!");
        return total;
        }
    public static void main(String[] args) {
        // initializes variables //
        String p1, p2;
        int dice, player1Total, player2Total;
        player1Total = 0;    player2Total = 0;
        // printout //
        p1 = printout(1);
        p2 = printout(2);
        System.out.println();
        // switches player turn
        for (int playerTurn = 1; (player1Total < 100 && player2Total < 100); playerTurn*= -1){
            // rolls dice
                if (playerTurn == 1)
                    player1Total += whoGotNext(p1, player1Total);
                if (playerTurn == -1)
                    player2Total += whoGotNext(p2, player2Total);
                System.out.println();
            }
        // winner display
        if (player1Total >= 100)
            System.out.println(p1 + " wins!");
        if (player2Total >= 100)
            System.out.println(p2 + " wins!");
    }
}
