package com.techelevator;

public class BalanceTracker extends FeedMoney
{
    // Variables
    private double currentBalance = 0.00;
    // money subtracted is accounted for as PROD PRICE : TOTAL BAL updated after Dispense
    private double amountSubtracted;
    // ADDs to TOTAL BAL : FeedMoney class implements this


    // getters
    public double getCurrentBalance()
    {
        return currentBalance;
    }

    public double getAmountSubtracted()
    {
        return amountSubtracted;
    }

    // setters
    // retrieve and set TOTAL with FeedMoney amount
    public void setCurrentBalance(double currentBalance)
    {
        this.currentBalance = getCurrentBalance() + getAmountInput();
    }

    // retrieve and set to PRICE
    public void setAmountSubtracted(double amountSubtracted)
    {
        this.amountSubtracted = amountSubtracted;
    }


    // need a way to exit when done putting in money
}
