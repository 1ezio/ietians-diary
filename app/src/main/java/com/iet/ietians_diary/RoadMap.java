package com.iet.ietians_diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.iet.ietians_diary.Adapters.RoadmapRecyclerViewAdapter;
import com.iet.ietians_diary.Models.RoadmapModels;

import java.util.ArrayList;

public class RoadMap extends AppCompatActivity {

    RecyclerView roadmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_map);

        roadmap = findViewById(R.id.roadmap_recyclerView);
        roadmap.setNestedScrollingEnabled(false);

        ArrayList<RoadmapModels> list = new ArrayList<>();
        list.add(new RoadmapModels("Android",R.drawable.feature_roadmap_bg_blue));
        list.add(new RoadmapModels("Kotlin", R.drawable.feature_roadmap_bg_red));
        list.add(new RoadmapModels("Java", R.drawable.feature_roadmap_bg_green));
        list.add(new RoadmapModels("Ruby", R.drawable.feature_roadmap_bg_grey));
        list.add(new RoadmapModels("Javascript", R.drawable.feature_roadmap_bg_blue));
        list.add(new RoadmapModels("Apple", R.drawable.feature_roadmap_bg_red));
        list.add(new RoadmapModels("Google", R.drawable.feature_roadmap_bg_green));
        list.add(new RoadmapModels("Mango", R.drawable.feature_roadmap_bg_grey));
        list.add(new RoadmapModels("Microsoft", R.drawable.feature_roadmap_bg_blue));
        list.add(new RoadmapModels("Dell", R.drawable.feature_roadmap_bg_red));
        list.add(new RoadmapModels("Amazon", R.drawable.feature_roadmap_bg_green));
        list.add(new RoadmapModels("Flipkart", R.drawable.feature_roadmap_bg_grey));

        RoadmapRecyclerViewAdapter RoadmapAdapter = new RoadmapRecyclerViewAdapter(list, RoadMap.this);
        roadmap.setAdapter(RoadmapAdapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        roadmap.setLayoutManager(staggeredGridLayoutManager);

    }
}