package com.iet.ietians_diary;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iet.ietians_diary.Adapters.RoadmapRecyclerViewAdapter;
import com.iet.ietians_diary.Models.RoadmapModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoadmapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoadmapFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RoadmapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RoadmapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoadmapFragment newInstance(String param1, String param2) {
        RoadmapFragment fragment = new RoadmapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_roadmap, container, false);

        RecyclerView roadmap = rootView.findViewById(R.id.roadmap_recyclerView);
        roadmap.setLayoutManager(new LinearLayoutManager(getActivity()));
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

        RoadmapRecyclerViewAdapter RoadmapAdapter = new RoadmapRecyclerViewAdapter(list, getContext());
        roadmap.setAdapter(RoadmapAdapter);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        roadmap.setLayoutManager(staggeredGridLayoutManager);

        // Inflate the layout for this fragment
        return rootView;
    }
}