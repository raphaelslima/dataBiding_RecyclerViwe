package com.example.waterapp;

import static com.example.waterapp.R.drawable.ic_glass_empty;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GlassViewModel extends ViewModel {
    public LiveData<Integer> getImagemCopo() {
        return imagemCopo;
    }

    public MainViewModel mainViewModel;

    private MutableLiveData<Integer> imagemCopo;
    private MutableLiveData<String> mlCopo;

    private Glass glass;

    public GlassViewModel(Glass glass, MainViewModel mainViewModel) {
        this.glass = glass;
        this.mainViewModel = mainViewModel;
        this.imagemCopo = new MutableLiveData<>();
        this.mlCopo = new MutableLiveData<>(Integer.toString(glass.getAmount()) + "ml");


    }

    public Glass getGlass() {
        return glass;
    }

    public MutableLiveData<String> getMlCopo() {
        return mlCopo;
    }

    public void toggleDrunk() {
        glass.toggleDrunk();

    }
}