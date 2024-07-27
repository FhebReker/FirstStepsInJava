/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-12-01
 @Description: Creates a monster, then allows the user to do certain things with the monster.
***********************************************
*/
import java.util.Scanner;
import java.util.Random;

public class Monster {
  // Create instance variables
    public String name, powerType;
    public int health, powerRating;
    public int powerPercent2 = 40;
    
    // Constructor
    public Monster(String mName, String mPowerType, int mHealth, int mPowerRating) {
        name = mName;
        powerType = mPowerType;
        health = mHealth;
        powerRating = mPowerRating;
    }

    public boolean battle(int powerPercent, Monster monster2) {
        Random rand = new Random();
        // When the monster starts a battle, they get a power and health boost.
        powerRating += 10;
        health += 5;
        int destroyMax = (int) (powerPercent/100.0 * powerRating);
        int destroyMax2 = (int) (powerPercent2/100.0 * monster2.powerRating);
        int destroyPoints = rand.nextInt(destroyMax);
        int destroyPoints2 = rand.nextInt(destroyMax2);
        System.out.println(name + " used " + powerType + " to inflict destruction of " + destroyPoints + " on " + monster2.name);
        System.out.println(monster2.name + " used " + monster2.powerType + " to inflict destruction of " + destroyPoints2 + " on " + name);
    
        if (destroyPoints >= destroyPoints2) {
        System.out.println(name + " wins this battle!  So " + monster2.name + "'s health is reduced by " + (destroyPoints + 10));
        monster2.health -= destroyPoints + 10;
        health -= destroyPoints2;
        }
        else {
            System.out.println(monster2.name + " wins!  So " + name + "'s health is reduced by " + (destroyPoints2 + 10));
            health -= destroyPoints2 + 10;
            monster2.health -= destroyPoints;
        }
        if (monster2.health <= 0) {
            System.out.println(monster2.name + " died. RIP. " + name + " wins.");
            return true; 
        }
        else if (health <= 0) {
            System.out.println(name + " died. RIP. " + monster2.name + " wins.");
            return true;
        }  // end else if  
        else return false;      
  }  // end battle method
  
/*
* Method Name: powerUp
*Author: Fardin Abbassi
* Creation Date; November 19, 2022
* Modified Date: December 01, 2022
*Description: Increases monster's power rating by 25
* @Parameters: n/a
* @Return Value: void
* Data Type: int
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
    public void powerUp(){
      powerRating += 25;
      System.out.println(name + " powered up by 25!");
    }
  
/*
* Method Name: healUp
*Author: Fardin Abbassi
* Creation Date; November 19, 2022
* Modified Date: December 01, 2022
*Description: Increases monster's health by 25
* @Parameters: n/a
* @Return Value: void
* Data Type: int
* Dependencies: n/a
*Throws/Exceptions: n/a
*/
    public void healUp(){
      health += 25;
      System.out.println(name + " healed up by 25!");
    }
}  // end Monster class









/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-12-01
 @Description: Creates 2 monsters, then lets 2 people fight using the monsters.
***********************************************
*/
class MonsterBattle {
    // monster variables
    public static String monsterName, weaponName;
    public static int monsterHealth, monsterPower;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp;
        char menuSelect;
        boolean death = false;
        
        System.out.println("Welcome to the monster battle");
        // Monster(String mName, String mPowerType, int mHealth, int mPowerRating)
        Monster m1 = monsterCreator(1);
        Monster m2 = monsterCreator(2);

        for (int playerTurn = 1; death != true; playerTurn *= -1){
            if (playerTurn == 1){
                System.out.println("Player 1's turn!");
                System.out.println("What would you like " + m1.name +" to do?\nBattle (B)\nPower Up (P)\nHeal (H) \nSurrender (S)");
                }
            else if (playerTurn == -1){
                System.out.println("Player 2's turn!");
                System.out.println("What would you like " + m2.name +" to do?\nBattle (B)\nPower Up (P)\nHeal (H) \nSurrender (S)");
                }
            
            // gets option
            temp = scanner.nextLine(); 
            temp = temp.toUpperCase();
            menuSelect = temp.charAt(0);
            System.out.println();
            
            if (playerTurn == 1)
                death = menuSelect(m1, m2, menuSelect);
            if (playerTurn == -1)
                death = menuSelect(m2, m1, menuSelect);
        }
    }
  
  /*
  * Method Name: monsterCreator
  *Author: Fardin Abbassi
  * Creation Date; November 19, 2022
  * Modified Date: December 01, 2022
  *Description: Creates a monster based on user input.
  * @Parameters: (int player)
  * @Return Value: Monster
  * Data Type: String
  * Dependencies: n/a
  *Throws/Exceptions: Input mismatch if health or power inputs are not integers.
  */
    public static Monster monsterCreator(int player){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + player +", please enter your monster's information here:");
        System.out.println("Enter your monster's name:");
        monsterName = scanner.nextLine();
        System.out.println("Enter your weapon/spell's name:");
        weaponName = scanner.nextLine();
        System.out.println("Enter your monster's health:");
        monsterHealth = scanner.nextInt();
        System.out.println("Enter your monster's power level:");
        monsterPower = scanner.nextInt();

        // Monster(String mName, String mPowerType, int mHealth, int mPowerRating)
        Monster m = new Monster(monsterName, weaponName, monsterHealth, monsterPower);
        System.out.println("Monster name: " + m.name + "\nWeapon/Spell: " + m.powerType 
        + "\nMonster health: " + m.health + "\nMonster power level: " + m.powerRating + "\n");
        return m;
    }
  
  /*
  * Method Name: menuSelect
  *Author: Fardin Abbassi
  * Creation Date; November 19, 2022
  * Modified Date: December 01, 2022
  *Description: Selects from battling, powering up, healing up or surrendering using user input.
  * @Parameters: (Monster m, Monster enemyM, char option)
  * @Return Value: boolean
  * Data Type: Monster
  * Dependencies: n/a
  *Throws/Exceptions: n/a
  */    
    public static boolean menuSelect(Monster m, Monster enemyM, char option){
        boolean death = false;
        switch (option){
                case 'B':
                    death = m.battle(80, enemyM);   return death;
                case 'P':
                    m.powerUp();    return death;
                case 'H':
                    m.healUp();     return death;
                case 'S':
                    System.out.println(m.name + " cannot continue, " + enemyM.name +"wins!");
                    death = true;   return death;
        }
        return death;
    }
}
