package com.iet.ietians_diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.iet.ietians_diary.Adapters.RoadmapRecyclerViewAdapter;
import com.iet.ietians_diary.Models.RoadmapModels;

import java.util.ArrayList;

public class RoadMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_map);
        RecyclerView roadmap;
        roadmap = findViewById(R.id.roadmap_recyclerView);
        roadmap.setNestedScrollingEnabled(false);
        ArrayList<RoadmapModels> list = new ArrayList<>();
        list.add(new RoadmapModels("Android"));
        list.add(new RoadmapModels("Kotlin"));
        list.add(new RoadmapModels("Java"));
        list.add(new RoadmapModels("Ruby"));
        list.add(new RoadmapModels("Javascript"));
        list.add(new RoadmapModels("Apple"));
        list.add(new RoadmapModels("Google"));
        list.add(new RoadmapModels("Mango"));
        list.add(new RoadmapModels("Microsoft"));
        list.add(new RoadmapModels("Dell"));
        list.add(new RoadmapModels("Michael Jordan"));
        list.add(new RoadmapModels("Nike"));
        list.add(new RoadmapModels("Casio"));
        list.add(new RoadmapModels("Orange"));

        RoadmapRecyclerViewAdapter RoadmapAdapter = new RoadmapRecyclerViewAdapter(list, RoadMap.this);
        roadmap.setAdapter(RoadmapAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(RoadMap.this, 2);
        roadmap.setLayoutManager(gridLayoutManager);

    }
}