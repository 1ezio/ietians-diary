package com.iet.ietians_diary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iet.ietians_diary.Adapters.RoadmapRecyclerViewAdapter;
import com.iet.ietians_diary.Models.RoadmapModel;

import java.util.ArrayList;

public class RoadmapFragment extends Fragment implements RoadmapRecyclerViewAdapter.clickListner{

    String[] links = {
            "https://roadmap.sh/android",
            "https://roadmap.sh/frontend",
            "https://roadmap.sh/backend",
            "https://www.geeksforgeeks.org/best-way-to-start-with-competitive-programming-geeksforgeeks-cp-live-course/",
            "https://workat.tech/general/article/open-source-contribution-guide-xmhf1k601vdj",
            "https://roadmap.sh/devops",
            "https://www.geeksforgeeks.org/how-to-become-data-scientist-a-complete-roadmap/",
            "https://www.kaggle.com/getting-started/174107",
            "https://medium.com/javarevisited/courses-roadmap-to-dominate-artificial-intelligence-15415e1e333a",
            "https://www.programmersought.com/article/85573414848/",
            "https://www.geeksforgeeks.org/how-to-prepare-for-gate-cs-2021/",
            "https://unacademy.com/class/cat-2021-detailed-roadmap-and-strategy/YIGURO0J",
    };

    public RoadmapFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_roadmap, container, false);

        RecyclerView roadmap = rootView.findViewById(R.id.roadmap_recyclerView);
        roadmap.setLayoutManager(new GridLayoutManager(getActivity(),2));
        roadmap.setNestedScrollingEnabled(false);

        ArrayList<RoadmapModel> list = new ArrayList<>();
        list.add(new RoadmapModel("Android Development",R.drawable.feature_roadmap_bg_blue));
        list.add(new RoadmapModel("Frontend Development", R.drawable.feature_roadmap_bg_red));
        list.add(new RoadmapModel("Backend Development", R.drawable.feature_roadmap_bg_green));
        list.add(new RoadmapModel("Competitive Programming", R.drawable.feature_roadmap_bg_grey));
        list.add(new RoadmapModel("Open Source Contribution", R.drawable.feature_roadmap_bg_blue));
        list.add(new RoadmapModel("DevOps", R.drawable.feature_roadmap_bg_red));
        list.add(new RoadmapModel("Data Science", R.drawable.feature_roadmap_bg_green));
        list.add(new RoadmapModel("Machine Learning", R.drawable.feature_roadmap_bg_grey));
        list.add(new RoadmapModel("Artificial Intelligence", R.drawable.feature_roadmap_bg_blue));
        list.add(new RoadmapModel("Internet Of Things", R.drawable.feature_roadmap_bg_red));
        list.add(new RoadmapModel("GATE", R.drawable.feature_roadmap_bg_green));
        list.add(new RoadmapModel("CAT", R.drawable.feature_roadmap_bg_grey));

        RoadmapRecyclerViewAdapter RoadmapAdapter = new RoadmapRecyclerViewAdapter(list, getContext(), this);
        roadmap.setAdapter(RoadmapAdapter);

        return rootView;
    }

    @Override
    public void clickListner(int position) {
        String url = links[position];
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }

}