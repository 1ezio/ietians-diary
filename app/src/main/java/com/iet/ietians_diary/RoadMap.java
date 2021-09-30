package com.iet.ietians_diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.iet.ietians_diary.Adapters.RoadmapRecyclerViewAdapter;
import com.iet.ietians_diary.Models.RoadmapModel;

import java.util.ArrayList;

public class RoadMap extends BaseActivity {

    private ConstraintLayout dynamicContent, bottomNav;
    private BottomNavigationView bottomNavigationView;

    private RecyclerView roadmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road_map);

//        dynamicContent = findViewById(R.id.contentContainer);
//        bottomNav = findViewById(R.id.bottomNavContainer);
//
//        View wizard = getLayoutInflater().inflate(R.layout.activity_road_map, null);
//        dynamicContent.addView(wizard);

        ColorStateList iconColorStates = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        getResources().getColor(R.color.text_black_200),
                        getResources().getColor(R.color.text_black_400)
                });

//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.favorite);
//        bottomNavigationView.setItemIconTintList(iconColorStates);
//        bottomNavigationView.setItemTextColor(iconColorStates);


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