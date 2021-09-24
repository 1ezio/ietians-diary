package com.iet.ietians_diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.iet.ietians_diary.Adapters.RoadmapRecyclerViewAdapter;
import com.iet.ietians_diary.Models.RoadmapModel;

import java.util.ArrayList;

public class RoadMap extends AppCompatActivity {

    RecyclerView roadmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_map);

        roadmap = findViewById(R.id.roadmap_recyclerView);
        roadmap.setNestedScrollingEnabled(false);

        ArrayList<RoadmapModel> list = new ArrayList<>();
        list.add(new RoadmapModel("Android",R.drawable.feature_roadmap_bg_blue));
        list.add(new RoadmapModel("Kotlin", R.drawable.feature_roadmap_bg_red));
        list.add(new RoadmapModel("Java", R.drawable.feature_roadmap_bg_green));
        list.add(new RoadmapModel("Ruby", R.drawable.feature_roadmap_bg_grey));
        list.add(new RoadmapModel("Javascript", R.drawable.feature_roadmap_bg_blue));
        list.add(new RoadmapModel("Apple", R.drawable.feature_roadmap_bg_red));
        list.add(new RoadmapModel("Google", R.drawable.feature_roadmap_bg_green));
        list.add(new RoadmapModel("Mango", R.drawable.feature_roadmap_bg_grey));
        list.add(new RoadmapModel("Microsoft", R.drawable.feature_roadmap_bg_blue));
        list.add(new RoadmapModel("Dell", R.drawable.feature_roadmap_bg_red));
        list.add(new RoadmapModel("Amazon", R.drawable.feature_roadmap_bg_green));
        list.add(new RoadmapModel("Flipkart", R.drawable.feature_roadmap_bg_grey));

        RoadmapRecyclerViewAdapter RoadmapAdapter = new RoadmapRecyclerViewAdapter(list, RoadMap.this);
        roadmap.setAdapter(RoadmapAdapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        roadmap.setLayoutManager(staggeredGridLayoutManager);

    }
}