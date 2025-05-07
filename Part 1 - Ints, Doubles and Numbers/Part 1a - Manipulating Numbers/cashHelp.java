/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-09-26
   @Description: Gives price, sales tax, paid amount, calculates bill and change, displays number of bills and coins required

***********************************************
*/
package assign1;

public class cashHelp {

	public static void main(String[] args) {
        double itemPurchased = 10.99;
        double paidAmount = 20.00;
        final double salesTax = 1.13;

        // Receipt Calcs//
        double totalBill = (itemPurchased * salesTax);
        totalBill = Math.round(totalBill*100)/100.0;
        double totalChange = (paidAmount - totalBill);

        // Receipt //                                               // should use "$" here for prices
        System.out.println("Price of Item(s): " + itemPurchased);
        System.out.println("HST: " + salesTax);                     // displays "1.13" instead of actual amount taxed
        System.out.println("Total: " + totalBill);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Change Given: " + totalChange);
        System.out.println();    
        
        // 20 in Change //
        int count20 = (int)totalChange / 20;
        System.out.println("20s: " + count20);
        totalChange %= 20;

        // 10 in Change //
        int count10 = (int)totalChange / 10;
        System.out.println("10s: " + count10);
        totalChange %= 10;

        // 5 in Change //        
        int count5 = (int)totalChange / 5;
        System.out.println("5s: " + count5);
        totalChange %= 5;
 
        // 2 in Change //        
        int count2 = (int)totalChange / 2;
        System.out.println("2s: " + count2);
        totalChange %= 2;
 
        // 1 in Change //            
        int count1 = (int)totalChange / 1;
        System.out.println("1s: " + count1);
        totalChange %= 1;

        // Quarters in Change //
        double count025 = totalChange / 0.25;
        System.out.println("Quarters: " + (int)count025);
        totalChange %= 0.25;
 
        // Dimes in Change //        
        double count010 = totalChange / 0.10;
        System.out.println("Dimes: " + (int)count010);
        totalChange %= 0.10;
 
        // Nickels in Change //        
        double count005 = totalChange / 0.05;
        System.out.println("Nickels: " + (int)count005);
        totalChange %= 0.05;
 
        // Pennies in Change //        
        double count001 = totalChange / 0.01;                    // Lost a penny due to no Math.round on this line when paidAmount = 43.53
        System.out.println("Pennies: " + (int)count001);
        totalChange %= 0.01;
	}
}
