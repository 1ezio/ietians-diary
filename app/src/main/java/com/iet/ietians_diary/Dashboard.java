package com.iet.ietians_diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends BaseActivity {

    private Button toRoad;
    private ConstraintLayout dynamicContent, bottomNav;
    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        dynamicContent = findViewById(R.id.contentContainer);
//        bottomNav = findViewById(R.id.bottomNavContainer);
//
//        View wizard = getLayoutInflater().inflate(R.layout.activity_dashboard, null);
//        dynamicContent.addView(wizard);

//        ColorStateList iconColorStates = new ColorStateList(
//                new int[][]{
//                        new int[]{-android.R.attr.state_checked},
//                        new int[]{android.R.attr.state_checked}
//                },
//                new int[]{
//                        getResources().getColor(R.color.text_black_200),
//                        getResources().getColor(R.color.text_black_400)
//                });
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelectedItemId(R.id.home);
//        bottomNavigationView.setItemIconTintList(iconColorStates);
//        bottomNavigationView.setItemTextColor(iconColorStates);

        toRoad = findViewById(R.id.buttonToRoad);
        toRoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, RoadMap.class));

            }
        });

    }
}