package com.techelevator;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Inventory {
    private String itemLocation;
    private String itemName;
    private BigDecimal itemPrice;
    private String itemType;
    private int itemQuantity;
    private String[] itemArray;
    private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Inventory() {}
    public Inventory(String[] itemArray, int itemQuantity) {
        this.itemArray = itemArray;
        this.itemQuantity = itemQuantity;
    }
    public Inventory(String itemLocation, String itemName, BigDecimal itemPrice, String itemType, int itemQuantity) {
        this.itemLocation = itemLocation;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemType = itemType;
        this.itemQuantity = 5;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity() {
        this.itemQuantity = itemQuantity;
    }

}
