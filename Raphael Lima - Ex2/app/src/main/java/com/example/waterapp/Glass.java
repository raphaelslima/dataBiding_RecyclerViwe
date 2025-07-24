package com.example.waterapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Glass {
    private int amount;
    private boolean isDrunk;

    private WaterObserver waterObserver;

    public Glass(int amount, WaterObserver waterObserver) {
        this.amount = amount;
        this.isDrunk = false;
        this.waterObserver = waterObserver;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isDrunk() {
        return isDrunk;
    }

    public void toggleDrunk() {
        this.isDrunk = !this.isDrunk;
        waterObserver.update();
    }
}