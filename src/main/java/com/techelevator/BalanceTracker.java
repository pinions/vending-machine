package com.techelevator;

import java.util.Scanner;

public class BalanceTracker {
    // Variables
    // this keeps the amount
    private double currentBalance = 0.00;

    // used to reset bal to 0 after done in menu 2
    private double startingBalance = 0.00;

    // money subtracted is accounted for as PROD PRICE : TOTAL BAL updated after Dispense
    private double amountSubtracted;

    // variable
    private int amountInput;


    // getters
    public double getCurrentBalance()
    {
        return currentBalance;
    }

    public double getAmountSubtracted()
    {
        return amountSubtracted;
    }

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

            System.out.println("Would you like to exit? Enter YES to exit, NO to continue: ");
            String userInputToExit = input.nextLine();

            if (userInputToExit.equalsIgnoreCase("YES"))
            {
                isUserDone = true;
            }
        }
        return amountInput;
    }

    // setters
    public void setCurrentBalanceAdded()      // FIGURE OUT WHERE/HOW TO CALL/IMPLEMENT
    {
        this.currentBalance = getCurrentBalance() + amountInput;
    }

    public void setCurrentBalanceSubtracted()     // subtract after each product dispense
    {
        this.currentBalance = getCurrentBalance() - getAmountSubtracted();
    }

    // retrieve and set to PRICE -> NEED TO INPUT PURCHASE PRICE
    public void setAmountSubtracted(double amountSubtracted)
    {
        this.amountSubtracted = amountSubtracted;
    }

    public void setCurrentToStartBalance()
    {
        this.currentBalance = startingBalance;
    }

}
