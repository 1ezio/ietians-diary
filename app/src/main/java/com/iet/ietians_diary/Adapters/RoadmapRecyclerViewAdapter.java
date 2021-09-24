package com.iet.ietians_diary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iet.ietians_diary.Models.RoadmapModels;
import com.iet.ietians_diary.R;
import com.iet.ietians_diary.RoadMap;

import java.util.ArrayList;

public class RoadmapRecyclerViewAdapter extends RecyclerView.Adapter<RoadmapRecyclerViewAdapter.viewHolder>{
    
    ArrayList<RoadmapModels> list;
    Context context;

    public RoadmapRecyclerViewAdapter(ArrayList<RoadmapModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_roadmap_card, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        RoadmapModels model = list.get(position);
        holder.name.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView name;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);

        }

    }
}

