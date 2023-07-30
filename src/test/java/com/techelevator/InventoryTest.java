package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InventoryTest
{
    @Test
    public void returns_all_data_regarding_inventory_item()
    {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();
        List<InventoryManager> inventoryList = new ArrayList<>();

        // Act
        inventoryManager.setItemLocation("B1");
        String location = "B1";

        inventoryManager.setItemName("Apple");
        String name = "Apple";

        inventoryManager.setItemPrice(BigDecimal.valueOf(1.25));
        BigDecimal price = BigDecimal.valueOf(1.25);

        inventoryManager.setItemType("Fruit");
        String type = "Fruit";

        inventoryManager.setItemQuantity(5);
        int quantity = 5;

        inventoryList.add(new InventoryManager(location, name, price, type, quantity));

        // Assert
        Assert.assertEquals( location, inventoryManager.getItemLocation() );
        Assert.assertEquals( name, inventoryManager.getItemName() );
        Assert.assertEquals( price, inventoryManager.getItemPrice() );
        Assert.assertEquals( type, inventoryManager.getItemType() );
        Assert.assertEquals( quantity, inventoryManager.getItemQuantity() );

    }

    @Test
    public void return_new_item_quantity()
    {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();

        // Act
        inventoryManager.setItemQuantity(5);

        // Assert
        Assert.assertEquals(4, inventoryManager.subtractItemQuantity());

    }

}
