package com.techelevator;

import java.util.Scanner;

public class BalanceTracker {
    // Variables
    private int amountInput;
    private double currentBalance = 0.00;   // tracks TOTAL
    private double startingBalance = 0.00;  // resets TOTAL to 0

    // --------------  getters  -----------------
    public double getCurrentBalance()
    {
        return currentBalance;
    }

    public int getAmountInput()
    {
        boolean isUserDone = false;

        while (isUserDone)  // while the user would like to continue to deposit money
        {
            // prompt user to enter an INT for dollar amount
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a dollar amount, as a whole number, that you would like to deposit: ");

            // store and change input to INT
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

    // ------------------  setters  ---------------------
    public void setCurrentBalanceAdded(double balanceAdded)  // FEED MONEY
    {
        this.currentBalance = getCurrentBalance() + balanceAdded;
    }

    public void setCurrentBalanceSubtracted(double purchasePrice)     // subtract after each product dispense
    {
        this.currentBalance = getCurrentBalance() - purchasePrice;
    }

    public void setCurrentToStartBalance()
    {
        this.currentBalance = startingBalance;
    }

}
