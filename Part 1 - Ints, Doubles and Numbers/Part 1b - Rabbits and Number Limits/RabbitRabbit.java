/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-10-02
 @Description: Defines rabbits, year, annual cost. Displays each for every year.

***********************************************
*/
public class RabbitRabbit {
    public static void main(String[] args) {
        
        // Defines variables
        int rabbits, year, annualCost;
        
        // Gives first values
        rabbits = 2;
        year = 2017;
        annualCost = 2 * rabbits * 12;
        
        // Loop
        while (year <= 2030)
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
    } // Main end
}
