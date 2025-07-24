package com.example.waterapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Glass>> glassesList = new MutableLiveData<>();
    private MutableLiveData<String> waterIntakeText = new MutableLiveData<>();
    private MutableLiveData<String> waterDrunkText = new MutableLiveData<>();
    private MutableLiveData<String> weight = new MutableLiveData<>();

    public MutableLiveData<String> getWaterIntakeText() {
        return waterIntakeText;
    }

    public int getVolumeCopoMl() {
        return volumeCopoMl;
    }

    public MutableLiveData<List<Glass>> getGlassesList() {
        return glassesList;
    }

    private int volumeCopoMl = 350;

    public MainViewModel() {
        glassesList.setValue(new ArrayList<>());
        waterIntakeText.setValue("0");
        waterDrunkText.setValue("0");
    }

    public MutableLiveData<String> getWeight(){
        return weight;
    }

    public void calculateWaterIntake() {
        int peso = Integer.parseInt(weight.getValue());
        int totalMl = peso * 35;
        int numCopos = (int) Math.ceil((double) totalMl / volumeCopoMl);
        List<Glass> glasses = new ArrayList<>();

        int totalMlAntigo = totalMl;
        for (int i = 0; i < numCopos; i++) {
            if(totalMl>volumeCopoMl){
                glasses.add(new Glass(volumeCopoMl, new WaterObserver(this)));
                totalMl-=volumeCopoMl;
            }else{
                glasses.add(new Glass(totalMl, new WaterObserver(this)));
            }
        }

        glassesList.postValue(glasses);
        waterIntakeText.setValue(Double.toString ((double)totalMlAntigo/(double)1000));
    }

    public MutableLiveData<String> getWaterDrunkText() {
        return waterDrunkText;
    }

    public void calculateWaterDrunk() {
        float totalDrunk = 0;
        List<Glass> glasses = glassesList.getValue();
        assert glasses != null;
        for (Glass g:glasses) {
            if(g.isDrunk()){
                totalDrunk+=g.getAmount();
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        waterDrunkText.postValue(df.format(totalDrunk/1000));
    }
}
