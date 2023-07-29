package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class InventoryManagerTest
{
    @Test
    public void create_and_return_an_inventory_list()
    {
        // Arrange and Act
        InventoryManager inventoryManager = new InventoryManager();

        File inventoryInput = new File("alternate.csv");



        // Assert
        Assert.assertEquals(  , inventoryManager.addToArray());
        Assert.assertEquals( , inventoryManager.printEachItem());




    }


}
