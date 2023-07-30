package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLog {
    public BalanceTracker balanceTracker = new BalanceTracker();

    // TODO do they want this to be a new file every time?
    public void createFile() {
        File transactionLog = new File("transaction-log.txt");

        if (!transactionLog.exists()) {
            try {
                transactionLog.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    // TODO do not print if input is invalid
    public void printToFile(File transactionLog, String transaction, BigDecimal moneyChange, BigDecimal currentBalance) {
        NumberFormat num = NumberFormat.getCurrencyInstance();

        try (PrintWriter writer = new PrintWriter(new FileWriter(transactionLog, true))) {
            writer.println(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a").format(LocalDateTime.now())
                    + " " + transaction + ": " + num.format(moneyChange) + " "
                    + num.format(currentBalance));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
