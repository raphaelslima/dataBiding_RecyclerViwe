package com.example.exercicio1_viewModelApp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LikesViewModel extends ViewModel {
    private MutableLiveData<Integer> imagemExibida;
    private MutableLiveData<Integer> qtdLike;

    public LikesViewModel() {
        imagemExibida = new MutableLiveData<>();
        qtdLike = new MutableLiveData<>();
        imagemExibida.setValue(R.drawable.like);
        qtdLike.setValue(0);
    }

    public LiveData<Integer> getImagemExibida() {
        return imagemExibida;
    }

    public LiveData<Integer> getQtdLike() {
        return qtdLike;
    }

    public void atualizarImagem() {
        Integer likes = qtdLike.getValue();
        if(likes>=0&&likes<4){
            imagemExibida.setValue(R.drawable.like);
        }else if(likes>=4&&likes<9){
            imagemExibida.setValue((R.drawable.coracao));
        }else{
            imagemExibida.setValue(R.drawable.fogo);
        }
    }

    public int getLikes() {
        Integer likes = qtdLike.getValue();
        return likes != null ? likes : 0;
    }

    public void darLike() {
        Integer likes = qtdLike.getValue();
        if (likes != null) {
            qtdLike.setValue(likes + 1);
        } else {
            qtdLike.setValue(1);
        }
        atualizarImagem();
    }
}

