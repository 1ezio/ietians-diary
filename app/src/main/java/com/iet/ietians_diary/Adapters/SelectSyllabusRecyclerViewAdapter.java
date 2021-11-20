package com.iet.ietians_diary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.iet.ietians_diary.Models.RoadmapModel;
import com.iet.ietians_diary.Models.SubjectModel;
import com.iet.ietians_diary.R;

import java.util.ArrayList;

public class SelectSyllabusRecyclerViewAdapter extends RecyclerView.Adapter<SelectSyllabusRecyclerViewAdapter.viewHolder>{

    ArrayList<SubjectModel> list;
    Context context;
    private ClickListener mClickListener;

    public SelectSyllabusRecyclerViewAdapter(ArrayList<SubjectModel> list, Context context, ClickListener mClickListener) {
        this.list = list;
        this.context = context;
        this.mClickListener = mClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_subject, parent,false);
        return new viewHolder(view, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        SubjectModel model = list.get(position);
        holder.name.setText(model.getName());
    }

    @Override
    public int getItemCount() {return list.size();}

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        ClickListener clickListenerObject;

        public viewHolder(@NonNull View itemView, ClickListener clickListenerObject) {
            super(itemView);

            name = itemView.findViewById(R.id.tvSubjectName);
            this.clickListenerObject = clickListenerObject;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListenerObject.clickListener(getAdapterPosition());
        }
    }

    public interface ClickListener
    {
        void clickListener(int position);
    }
}

