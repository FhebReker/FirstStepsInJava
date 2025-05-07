/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-10-02
 @Description: Defines rabbits, year, annual cost. Displays each for every year until the cost reaches 2 billion.

***********************************************
*/
public class RabbitRabbit {
    public static void main(String[] args) {
        
        // Defines variables
        long rabbits, year, annualCost;

        // Gives first values
        rabbits = 2;
        year = 2017;
        annualCost = 2 * rabbits * 12;
        
        // Loop
        while (annualCost < 2000000000)
        {
            // Recurring printing
            System.out.println("Year: " + year);
            System.out.println("Rabbits: " + rabbits);
            System.out.println("Annual Cost: $" + annualCost);
            System.out.println();
            
            // Updates values
            rabbits *= 2;
            year += 1;
            annualCost = 2 * rabbits * 12;
            
        } // Loop end
        
        // Final statement
        System.out.println("Year: " + year);
        System.out.println("Rabbits: " + rabbits);
        System.out.println("Annual Cost: $" + annualCost);
        System.out.println();
        System.out.print("Amount of years taken: " + (year - 2017));

    } // Main end
}
