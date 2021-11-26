package com.iet.ietians_diary.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.iet.ietians_diary.Models.DashboardNewFeaturesModel;
import com.iet.ietians_diary.R;

import java.util.ArrayList;

public class DashboardNewFeaturesRecyclerViewAdapter extends RecyclerView.Adapter<DashboardNewFeaturesRecyclerViewAdapter.viewHolder>{

    ArrayList<DashboardNewFeaturesModel> list;
    Context context;

    public DashboardNewFeaturesRecyclerViewAdapter(ArrayList<DashboardNewFeaturesModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.component_newfeature_card, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DashboardNewFeaturesModel model = list.get(position);

        holder.cardName.setText(model.getName());
        holder.description.setText(model.getDescription());
        holder.constraintLayout.setBackgroundResource(model.getBgColor());
        //holder.textView1.setBackgroundResource(model.getBgColorTV());
        //holder.textView2.setBackgroundResource(model.getBgColorTV());

        if(position==0){
            holder.constraintLayout1.setPadding(0,16,16,0);
        }
        else{
            holder.constraintLayout1.setPadding(16,16,16,0);
        }

    }

    @Override
    public int getItemCount() { return list.size(); }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView cardName, description, textView1, textView2;
        ConstraintLayout constraintLayout, constraintLayout1;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            cardName = itemView.findViewById(R.id.tvDiscussionForm);
            description = itemView.findViewById(R.id.tvDescription);
            constraintLayout = itemView.findViewById(R.id.newFeatures_constrainLayout);
            constraintLayout1 = itemView.findViewById(R.id.newFeatureContainer);
            //textView1 = itemView.findViewById(R.id.tvInterview);
            //textView2 = itemView.findViewById(R.id.tvExams);

        }
    }
}
