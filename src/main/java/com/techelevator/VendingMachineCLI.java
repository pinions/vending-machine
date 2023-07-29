package com.techelevator;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Scanner;

/*
 * This class is provided to you as a *suggested* class to start
 * your project. Feel free to refactor this code as you see fit.
 */
public class VendingMachineCLI {

	private static final Scanner scanner = new Scanner(System.in);

	private MenuDisplay menuDisplay = new MenuDisplay();
	private PurchaseMenuDisplay purchaseDisplay = new PurchaseMenuDisplay();
	private BalanceTracker balanceTracker = new BalanceTracker();
	private BigDecimal currentBalance = balanceTracker.getCurrentBalance();

	public static void main(String[] args) {
		VendingMachineCLI cli = new VendingMachineCLI();
		cli.run();
	}

	public void run() {
		menuDisplay.mainMenu();
		purchaseDisplay.purchaseMenu();
	}

}
