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
        Inventory inventory = new Inventory();

        // Act
        inventory.setItemLocation("B1");

        inventory.setItemName("Apple");

        inventory.setItemPrice(BigDecimal.valueOf(1.25));
        BigDecimal applePrice = BigDecimal.valueOf(1.25);

        inventory.setItemQuantity(5);

        inventory.setItemType("fruit");

        // Assert
        Assert.assertEquals( "B1", inventory.getItemLocation() );
        Assert.assertEquals( "Apple", inventory.getItemName() );
        Assert.assertEquals( applePrice, inventory.getItemPrice() );
        Assert.assertEquals( 5, inventory.getItemQuantity() );
        Assert.assertEquals( "fruit", inventory.getItemType() );

    }
}
