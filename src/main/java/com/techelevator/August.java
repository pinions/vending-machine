package com.techelevator;

import java.util.Calendar;

public class August {
    private int augustCounter = 0;

    public boolean isAugust() {
        return Calendar.getInstance().get(Calendar.MONTH) == Calendar.AUGUST;
    }

    public void setAugustCounter(int augustCounter) {
        this.augustCounter = augustCounter;
    }

    public int getAugustCounter() {
        return augustCounter += 1;
    }

}
