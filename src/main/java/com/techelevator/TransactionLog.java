package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLog {

    public static void main(String[] args) {
        TransactionLog transactionLog = new TransactionLog();
        transactionLog.run();
    }

    public void run() {
        NumberFormat numFormat = NumberFormat.getCurrencyInstance();
        BigDecimal inputMoney = BigDecimal.valueOf(5.00);
        BigDecimal itemPrice = BigDecimal.valueOf(1.50);

        File transactionLog = new File("transaction-log.txt");
        try {
            transactionLog.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("File located at " + transactionLog.getName());

        try (PrintWriter writer = new PrintWriter(transactionLog)) {
            writer.println(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a").format(LocalDateTime.now())
                    + " FEED MONEY: " + numFormat.format(inputMoney) + " "
                    + numFormat.format(itemPrice));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
