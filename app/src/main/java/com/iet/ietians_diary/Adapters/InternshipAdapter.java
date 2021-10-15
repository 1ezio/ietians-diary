package com.iet.ietians_diary.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.iet.ietians_diary.Models.InternshipModel;
import com.iet.ietians_diary.R;


import java.util.List;


public class InternshipAdapter extends RecyclerView.Adapter<InternshipAdapter.InternshipViewHolder> {
    Context context;
    List<InternshipModel> internshipList;

    public InternshipAdapter(Context context, List<InternshipModel> categoryList) {
    }

    @NonNull
    @Override
    public InternshipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_internship_layout, parent, false);
        return new InternshipViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull InternshipViewHolder holder, int position) {
        InternshipModel model = internshipList.get(position);

        Glide.with(context).load(internshipList.get(position).getinternshipImage()).into(holder.internshipImage);
        holder.companyName.setText(internshipList.get(position).getcompanyName());
        holder.internRole.setText(internshipList.get(position).getinternRole());
        holder.description.setText(internshipList.get(position).getdescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.co.in/"));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return internshipList.size();
    }

    public class InternshipViewHolder extends ViewHolder{


        String id;
        ImageView internshipImage;
        TextView companyName;
        TextView internRole;
        TextView description;
        String internshipUrl;


        public InternshipViewHolder(@NonNull View itemView) {
            super(itemView);
            companyName = itemView.findViewById(R.id.companyName);
            internRole = itemView.findViewById(R.id.InternshipTitle);
            description = itemView.findViewById(R.id.intern_desc);



        }

    }
}
