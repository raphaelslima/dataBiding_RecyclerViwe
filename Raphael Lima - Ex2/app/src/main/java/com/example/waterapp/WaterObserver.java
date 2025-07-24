package com.example.waterapp;

public class WaterObserver {
    private MainViewModel mv;
    public WaterObserver(MainViewModel mv){
        this.mv = mv;
    }

    public void update(){
        mv.calculateWaterDrunk();
    }
}
