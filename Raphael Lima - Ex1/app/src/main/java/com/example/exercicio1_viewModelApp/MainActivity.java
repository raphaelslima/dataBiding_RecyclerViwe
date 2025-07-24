package com.example.exercicio1_viewModelApp;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.databinding.DataBindingUtil;
import com.example.exercicio1_viewModelApp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private LikesViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurar DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        // Obter a ViewModel
        viewModel = new ViewModelProvider(this).get(LikesViewModel.class);

        // Vincular a ViewModel
        binding.setViewModel(viewModel); // Verifique se essa linha não gera erros
    }

    @BindingAdapter("android:src")
    public static void bindImagem(ImageView iv, int imagem){
        iv.setImageResource(imagem);
    }
}