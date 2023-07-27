package com.techelevator;

import java.math.BigDecimal;

public interface Purchasable
{
    BigDecimal purchasePrice();
    String purchaseName();
    String purchaseMessage();

    int quantityRemaining();
    boolean isStocked();
}
