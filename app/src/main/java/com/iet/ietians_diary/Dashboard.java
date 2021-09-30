package com.iet.ietians_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button toRoad, toSyllabus, toStudyMaterial, toLabAssign, toInternships;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toRoad = findViewById(R.id.buttonToRoad);
        toRoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, RoadMap.class));

            }
        });

        toSyllabus=findViewById(R.id.buttonToSyllabus);
        toSyllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, Syllabus.class));
            }
        });

        toStudyMaterial=findViewById(R.id.buttonToStudyMaterial);
        toStudyMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, StudyMaterial.class));
            }
        });

        toLabAssign=findViewById(R.id.buttonToLabAssign);
        toLabAssign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, LabAssignment.class));
            }
        });

        toInternships=findViewById(R.id.buttonToInternships);
        toInternships.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, Internship.class));
            }
        });
    }
}