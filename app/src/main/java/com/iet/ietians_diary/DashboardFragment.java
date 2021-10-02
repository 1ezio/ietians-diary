package com.iet.ietians_diary;


import android.content.Intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.iet.ietians_diary.Adapters.DashboardAllFeaturesRecyclerViewAdapter;
import com.iet.ietians_diary.Models.DashboardAllFeaturesModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment implements DashboardAllFeaturesRecyclerViewAdapter.clickListner {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        RecyclerView dashboard = rootView.findViewById(R.id.allFeatures_recyclerView);
        dashboard.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
        dashboard.setNestedScrollingEnabled(false);

        ArrayList<DashboardAllFeaturesModel> list = new ArrayList<>();
        list.add(new DashboardAllFeaturesModel("Syllabus", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_blue));
        list.add(new DashboardAllFeaturesModel("Previous Papers", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_green));
        list.add(new DashboardAllFeaturesModel("Class", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_grey));
        list.add(new DashboardAllFeaturesModel("Branch", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_red));
        list.add(new DashboardAllFeaturesModel("Name", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_blue));
        list.add(new DashboardAllFeaturesModel("RollNo.", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_green));
        list.add(new DashboardAllFeaturesModel("Clg", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_grey));
        list.add(new DashboardAllFeaturesModel("Date", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_red));
        list.add(new DashboardAllFeaturesModel("DOB", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_blue));
        list.add(new DashboardAllFeaturesModel("Ghost", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_green));
        list.add(new DashboardAllFeaturesModel("Syllabus", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_grey));
        list.add(new DashboardAllFeaturesModel("Class", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_red));
        list.add(new DashboardAllFeaturesModel("CS", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_blue));
        list.add(new DashboardAllFeaturesModel("IT", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_green));
        list.add(new DashboardAllFeaturesModel("Sports", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_grey));
        list.add(new DashboardAllFeaturesModel("Last", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_red));

        DashboardAllFeaturesRecyclerViewAdapter dashboardAllFeatures = new DashboardAllFeaturesRecyclerViewAdapter(list, getContext(),this  );
        dashboard.setAdapter(dashboardAllFeatures);


        return rootView;
    }

    @Override
    public void clickListner(int position) {
        Intent i = new Intent(getContext(), SelectDetails.class);
        startActivity(i);
    }
}