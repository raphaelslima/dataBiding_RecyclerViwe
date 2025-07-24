package com.example.waterapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.example.waterapp.databinding.GlassViewModelBinding;

import java.util.List;

public class GlassAdapter extends RecyclerView.Adapter<GlassAdapter.GlassViewHolder> {

    private List<Glass> glassList;

    public GlassAdapter(List<Glass> glassList) {
        this.glassList = glassList;
    }

    @NonNull
    @Override
    public GlassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        GlassViewModelBinding binding = DataBindingUtil.inflate(inflater, R.layout.glass_view_model, parent, false);
        binding.setLifecycleOwner((LifecycleOwner) parent.getContext());
        return new GlassViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GlassViewHolder holder, int position) {
        Glass glass = glassList.get(position);
        GlassViewModel viewModel = new GlassViewModel(glass, new MainViewModel());
        holder.bind(viewModel);
    }

    @Override
    public int getItemCount() {
        return glassList.size();
    }

    static class GlassViewHolder extends RecyclerView.ViewHolder {
        private final GlassViewModelBinding binding;

        public GlassViewHolder(GlassViewModelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(GlassViewModel viewModel) {
            binding.setGlassViewModel(viewModel);
            binding.executePendingBindings();
        }
    }
}
