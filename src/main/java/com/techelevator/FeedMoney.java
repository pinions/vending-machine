package com.techelevator;


// Accessed in 2nd MENU option 1

// ADDS money to BALANCE

import java.util.Scanner;

public class FeedMoney
{
    // variable
    private int amountInput;

    public int getAmountInput()
    {
        // while the user would like to continue to deposit money
        boolean isUserDone = false;

        while (isUserDone) {
            // prompt user to enter an INT for dollar amount
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a dollar amount, as a whole number, that you would like to deposit: ");
            String userInputForDeposit = input.nextLine();

            int userDepositAsInt = Integer.parseInt(userInputForDeposit);

            amountInput += userDepositAsInt;

            System.out.println("Would you like to exit? Enter YES to exit, NO to stay: ");
            String userInputToExit = input.nextLine();

            if (userInputToExit.equalsIgnoreCase("YES"))
            {
                isUserDone = true;
            }
        }
        return amountInput;
    }

}
