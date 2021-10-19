package com.iet.ietians_diary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iet.ietians_diary.Models.SelectSyllabusModal;
import com.iet.ietians_diary.R;

import java.util.ArrayList;

public class SelectSyllabusRecyclerViewAdapter extends RecyclerView.Adapter<SelectSyllabusRecyclerViewAdapter.viewHolder>{

    Context context;
    ArrayList<SelectSyllabusModal> list;
    private clickListner mclicklistner;

    public SelectSyllabusRecyclerViewAdapter(Context context, ArrayList<SelectSyllabusModal> list, clickListner mclicklistner) {
        this.context = context;
        this.list = list;
        this.mclicklistner = mclicklistner;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_subject_name, parent,false);
        return new viewHolder(view, mclicklistner);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectSyllabusRecyclerViewAdapter.viewHolder holder, int position) {

        SelectSyllabusModal model = list.get(position);
        holder.subjectName.setText(model.getSubjectName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView subjectName;
        clickListner clickListnerObject;

        public viewHolder(@NonNull View itemView, clickListner mclicklistner) {
            super(itemView);

            subjectName = itemView.findViewById(R.id.tvSubjectNameTitle);
            this.clickListnerObject = clickListnerObject;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) { clickListnerObject.clickListner(getAdapterPosition()); }
    }

    public  interface clickListner
    {
        void clickListner(int position);
    }
}
