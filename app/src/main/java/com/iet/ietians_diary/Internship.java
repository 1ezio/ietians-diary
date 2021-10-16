package com.iet.ietians_diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.iet.ietians_diary.Adapters.InternshipAdapter;
import com.iet.ietians_diary.Models.InternshipModel;

import java.util.ArrayList;
import java.util.List;

public class Internship extends AppCompatActivity {

    private RecyclerView internship_recyler;
    private ArrayList<InternshipModel> internshipList;
    private InternshipAdapter internshipAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship);


        InternshipModel internship = new InternshipModel();
        internship.setid("0");
        internship.setcompanyName("Company_Name");
        internship.setdescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Qui dicta minus molestiae vel beatae natus eveniet ratione temporibus aperiam harum alias officiis assumenda officia quibusdam deleniti eos cupiditate dolore doloribus!");
        internship.setinternRole("role");
        internship.setinternshipImage("Image Url Here");
        internship.setinternshipUrl("www.google.com");
        internshipList.add(internship);

        internshipAdapter = new InternshipAdapter(this, internshipList);
        internship_recyler.setAdapter(internshipAdapter);




    }


}