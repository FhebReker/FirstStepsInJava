/**
***********************************************
 @Author      : Fardin Abbassi
 @Last Modified: 2022-10-02
 @Description: Inputs date, name, hourly rate, hours worked, tax bracket, charity donation, then calculates gross pay, net pay and deductions.

***********************************************
*/
import java.util.Scanner;

public class WantsAndNeeds {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int afterHours, grossPay, hours, payRate, netPay, deduction;
        String slipDate, familyName, givenName, rateOfPay, hoursWorked, taxCode, charityDonation;

        /* Date */
        System.out.print("Enter date: ");
        slipDate = scn.nextLine();
        System.out.println();
        
        /* Last Name */
        System.out.print("Enter Last Name: ");
        familyName = scn.nextLine();
        System.out.println();
        
        /* First Name */
        System.out.print("Enter First Name: ");
        givenName = scn.nextLine();
        System.out.println();
        
        /* Pay Rate */
        System.out.print("Enter rate of pay: ");
        rateOfPay = scn.nextLine();
        System.out.println();
        
        /* Hours */
        System.out.print("Enter hours worked: ");
        hoursWorked = scn.nextLine();
        System.out.println();
        
        /* Tax Code */
        System.out.println("Enter Tax Category: \n(Note: A = None, B = 10%, C = 20%, D = 29%, E = 35%)");
        taxCode = scn.nextLine();
        char tax = taxCode.toUpperCase().charAt(0);
        System.out.println();

        /* Charity Donation */
        System.out.println("Would you like to donate to United Way Charity? \n(Y for yes, N for No)");
        charityDonation = scn.nextLine();
        char charity = charityDonation.toUpperCase().charAt(0);
        System.out.println();
        
        /* Translates to int */
        hours = Integer.parseInt(hoursWorked);
        payRate = Integer.parseInt(rateOfPay);
        
        /* Calculates after hour work */
        if (hours > 40)
            afterHours = hours - 40;
        else
            afterHours = 0;
        
        /* Calculates gross pay, sets up net pay and deductions */
        grossPay = payRate * (hours + 2 * afterHours);
        netPay = grossPay;
        deduction = 0;

        /* Pay Slip */
        System.out.println("Pay slip for the week ending: " + slipDate);
        System.out.println("Full name: " + givenName + " " + familyName);
        System.out.println("Gross Pay: $" + grossPay);
        
        /* Tax Code switch case */
        switch(tax){
            case 'B': deduction += 10 * (grossPay / 100); break;
            case 'C': deduction += 20 * (grossPay / 100);  break;
            case 'D': deduction += 29 * (grossPay / 100); break;
            case 'E': deduction += 35 * (grossPay / 100); break;
        }
        
        /* Charity Donation check */
        if (charity == 'Y')
            deduction += 20;

        /* Deduction check */
        if (deduction > 0)
            System.out.println("Deductions: $" + deduction);
        else
            System.out.println("No deductions!");
        
        /* Net pay calculation and printing */
        netPay -= deduction;
        System.out.println("Net pay: $" + netPay);

    }
}
