package com.iet.ietians_diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.iet.ietians_diary.Adapters.SelectSyllabusRecyclerViewAdapter;
import com.iet.ietians_diary.Models.SubjectModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectSelection extends AppCompatActivity implements SelectSyllabusRecyclerViewAdapter.ClickListener{

    private SelectSyllabusRecyclerViewAdapter selectSyllabusRecyclerViewAdapter;
    private RecyclerView recyclerView;
    private FirebaseDatabase database;
    private DatabaseReference syllabus;
    private ArrayList<SubjectModel> subjects;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_selection);

        recyclerView = findViewById(R.id.subject_recylcerview);

        Intent intent = getIntent();
        String branch = intent.getStringExtra("branch");
        String sem = intent.getStringExtra("sem");

        loading = findViewById(R.id.loading);
        loading.setVisibility(View.VISIBLE);
        subjects = new ArrayList<>();

        database= FirebaseDatabase.getInstance();

        if(branch.toLowerCase().equals("it")){
            syllabus = database.getReference("Syllabi/IT/" + sem.toLowerCase());
        }else{
            syllabus = database.getReference("Syllabi/"+branch.toLowerCase() + "/" + sem.toLowerCase());
        }

        syllabus.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {};
                    Map<String, Object> objectHashMap = snapshot.getValue(objectsGTypeInd);

                    for(Object obj: objectHashMap.values()){
                        if(obj instanceof Map){
                            Map<String, Object> mapObj = (Map<String, Object>) obj;
                            SubjectModel subject = new SubjectModel();
                            subject.setName(mapObj.get("sname").toString());
                            subject.setUrl(mapObj.get("surl").toString());
                            subjects.add(subject);
                        }
                    }

                    loading.setVisibility(View.GONE);
                    selectSyllabusRecyclerViewAdapter =  new SelectSyllabusRecyclerViewAdapter(subjects, getApplicationContext(), SubjectSelection.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(selectSyllabusRecyclerViewAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Some error occurred!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    // Click listener for opening browser explicitly to read PDF
    @Override
    public void clickListener(int position) {
        SubjectModel subject = subjects.get(position);
        String urlString = subject.getUrl();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setPackage("com.android.chrome");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "Chrome not found :(", Toast.LENGTH_SHORT).show();
            intent.setPackage(null);
            startActivity(intent);
        }

    }
}