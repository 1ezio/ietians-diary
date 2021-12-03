package com.iet.ietians_diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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
    private DatabaseReference reference;
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
        String chosenOption = intent.getStringExtra("selectedOption");

        loading = findViewById(R.id.loading);
        loading.setVisibility(View.VISIBLE);
        subjects = new ArrayList<>();

        database= FirebaseDatabase.getInstance();
        String chosen = getCategory(chosenOption);

        if(branch.toLowerCase().equals("it")){
            reference = database.getReference(chosen.equals("syllabus") ? "Syllabi/IT/"
                    + sem.toLowerCase() : "study_material/IT/"
                    + sem.toLowerCase()+ "/" + chosen);
        }else {
            reference = database.getReference(chosen.equals("syllabus") ? "Syllabi/" + branch.toLowerCase() + "/" + sem.toLowerCase()
                    : "study_material/"+ branch.toLowerCase() + "/" + sem.toLowerCase()+ "/" + chosen);
        }

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    GenericTypeIndicator<HashMap<String, Object>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Object>>() {};
                    Map<String, Object> objectHashMap = snapshot.getValue(objectsGTypeInd);

                    for(Object obj: objectHashMap.values()){
                        if(obj instanceof Map){
                            Map<String, Object> mapObj = (Map<String, Object>) obj;
                            SubjectModel subject = new SubjectModel();
                            subject.setName(mapObj.get(chosenOption.equals("syllabus") ? "sname" : "smname").toString());
                            subject.setUrl(mapObj.get(chosenOption.equals("syllabus") ? "surl" : "smurl").toString());
                            subjects.add(subject);
                        }
                    }

                    loading.setVisibility(View.GONE);
                    selectSyllabusRecyclerViewAdapter =  new SelectSyllabusRecyclerViewAdapter(subjects, getApplicationContext(), SubjectSelection.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                    recyclerView.setAdapter(selectSyllabusRecyclerViewAdapter);
                }else{
                    loading.setVisibility(View.GONE);
                    AlertDialog.Builder builder = new AlertDialog.Builder(SubjectSelection.this);
                    LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                    View dialogView = inflater.inflate(R.layout.component_not_found, null);
                    builder.setView(dialogView);
                    AlertDialog alertDialog = builder.create();

                    Button helpBtn = dialogView.findViewById(R.id.btnHelp);
                    Button cancelBtn = dialogView.findViewById(R.id.btnCancel);

                    helpBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String urlString = "https://github.com/1ezio/ietians-diary";
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
                    });

                    cancelBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            alertDialog.cancel();
                            finish();
                        }
                    });

                    alertDialog.show();

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

    private String getCategory(String title){
        if(title.equals("Previous Papers")){
            return "papers";
        }

        return title.toLowerCase();
    }
}