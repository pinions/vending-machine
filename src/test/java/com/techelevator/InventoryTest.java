package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class InventoryTest
{
    @Test
    public void returns_all_data_regarding_inventory_item()
    {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();

        // Act
        inventoryManager.setItemLocation("B1");

        inventoryManager.setItemName("Apple");

        inventoryManager.setItemPrice(BigDecimal.valueOf(1.25));
        BigDecimal applePrice = BigDecimal.valueOf(1.25);

        inventoryManager.setItemQuantity(5);

        inventoryManager.setItemType("fruit");


        // Assert
        Assert.assertEquals( "B1", inventoryManager.getItemLocation() );
        Assert.assertEquals( "Apple", inventoryManager.getItemName() );
        Assert.assertEquals( applePrice, inventoryManager.getItemPrice() );
        Assert.assertEquals( 5, inventoryManager.getItemQuantity() );
        Assert.assertEquals( "fruit", inventoryManager.getItemType() );

    }
}
