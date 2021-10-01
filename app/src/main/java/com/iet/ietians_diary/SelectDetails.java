package com.iet.ietians_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SelectDetails extends AppCompatActivity {

    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_details);

        btnNext = findViewById(R.id.btnNextFromSelectBranch);
        btnNext.setEnabled(false);



    }
}