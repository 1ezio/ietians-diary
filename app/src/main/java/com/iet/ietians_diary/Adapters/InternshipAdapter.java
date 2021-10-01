package com.iet.ietians_diary.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class InternshipAdapter extends RecyclerView.Adapter<InternshipAdapter.InternshipViewHolder> {

    @NonNull
    @Override
    public InternshipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull InternshipViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class InternshipViewHolder extends RecyclerView.ViewHolder{


        public InternshipViewHolder(@NonNull View itemView) {
            super(itemView);


        }

    }
}
