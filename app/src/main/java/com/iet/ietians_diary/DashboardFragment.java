package com.iet.ietians_diary;


import android.app.AlertDialog;
import android.content.Intent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.iet.ietians_diary.Adapters.DashboardAllFeaturesRecyclerViewAdapter;
import com.iet.ietians_diary.Adapters.DashboardNewFeaturesRecyclerViewAdapter;
import com.iet.ietians_diary.Models.DashboardAllFeaturesModel;
import com.iet.ietians_diary.Models.DashboardNewFeaturesModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment implements DashboardAllFeaturesRecyclerViewAdapter.ClickListener {

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

    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        TextView name = rootView.findViewById(R.id.tvName);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        name.setVisibility(View.VISIBLE);
        name.setText(currentUser.getDisplayName());


        RecyclerView allFeatures = rootView.findViewById(R.id.allFeatures_recyclerView);
        RecyclerView newFeatures = rootView.findViewById(R.id.newFeatures_recyclerView);

        newFeatures.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        newFeatures.setNestedScrollingEnabled(false);

        ArrayList<DashboardNewFeaturesModel> list1 = new ArrayList<>();
        list1.add(new DashboardNewFeaturesModel("Discussion Forum", "Coming Soon", R.drawable.feature_discussion_forum_bg_blue, R.drawable.feature_discussion_forum_textview_bg_blue));
        list1.add(new DashboardNewFeaturesModel("Interview", "Coming Soon", R.drawable.feature_discussion_forum_bg_green, R.drawable.feature_discussion_forum_textview_bg_green));
        list1.add(new DashboardNewFeaturesModel("Internship", "Coming Soon", R.drawable.feature_discussion_forum_bg_grey, R.drawable.feature_discussion_forum_textview_bg_grey));
        list1.add(new DashboardNewFeaturesModel("Upload", "Coming Soon", R.drawable.feature_discussion_forum_bg_red, R.drawable.feature_discussion_forum_textview_bg_red));

        DashboardNewFeaturesRecyclerViewAdapter dashboardNewFeatures = new DashboardNewFeaturesRecyclerViewAdapter(list1, getContext());
        newFeatures.setAdapter(dashboardNewFeatures);

        allFeatures.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
        allFeatures.setNestedScrollingEnabled(false);

        ArrayList<DashboardAllFeaturesModel> list = new ArrayList<>();
        list.add(new DashboardAllFeaturesModel("Syllabus", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_blue));
        list.add(new DashboardAllFeaturesModel("Notes", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_green));
        list.add(new DashboardAllFeaturesModel("Books", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_grey));
        list.add(new DashboardAllFeaturesModel("Practical", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_red));
        list.add(new DashboardAllFeaturesModel("Previous Papers", "Lorem Ipsum is \nsimpledummy text.",R.drawable.ic_syllabus, R.drawable.feature_icon_bg_blue));

        DashboardAllFeaturesRecyclerViewAdapter dashboardAllFeatures = new DashboardAllFeaturesRecyclerViewAdapter(list, getContext(),this  );
        allFeatures.setAdapter(dashboardAllFeatures);

        return rootView;
    }

    @Override
    public void clickListener(int position) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.component_select_details, null);
        dialogBuilder.setView(dialogView);
        AlertDialog alertDialog = dialogBuilder.create();

        String[] Select_Branch = new String[] {"CS", "IT", "EI", "ETC", "Mech", "Civil"};
        ArrayAdapter<String> adapter_branch =  new ArrayAdapter<>(getContext(), R.layout.component_drop_down_item, Select_Branch);
        AutoCompleteTextView branch = dialogView.findViewById(R.id.selectBranch);
        branch.setAdapter(adapter_branch);

        String[] Select_Sem = new String[] {"Sem-1", "Sem-2", "Sem-3", "Sem-4", "Sem-5", "Sem-6", "Sem-7", "Sem-8"};
        ArrayAdapter<String> adapter_sem =  new ArrayAdapter<>(getContext(), R.layout.component_drop_down_item, Select_Sem);
        AutoCompleteTextView sem = dialogView.findViewById(R.id.selectSem);
        sem.setAdapter(adapter_sem);

        Button submit = (Button) dialogView.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Branch = branch.getEditableText().toString();
                String Sem = sem.getEditableText().toString();

                Intent i = new Intent(getContext(), SubjectSelection.class);
                i.putExtra("branch", Branch);
                i.putExtra("sem", Sem);
                startActivity(i);

                alertDialog.cancel();
            }
        });
        alertDialog.show();
    }
}