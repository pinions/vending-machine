package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AugustTest
{
    @Test
    public void returns_correct_august_buy_count()
    {
        // Arrange
        August august = new August();

        // Act
        august.setAugustCounter(2);

        // Assert
        Assert.assertEquals( 3, august.getAugustCounter());
        // Assert.assertEquals( false, august.isAugust());
        // Assert.assertEquals( true, august.isAugust());
    }
}
