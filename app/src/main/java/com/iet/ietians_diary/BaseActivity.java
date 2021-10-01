package com.iet.ietians_diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ImageView accountImage;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mAuth = FirebaseAuth.getInstance();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.container, new DashboardFragment());
        fragmentTransaction.commit();

        accountImage = findViewById(R.id.ivAccountImg);


        ColorStateList iconColorStates = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_checked}
                },
                new int[]{
                        getResources().getColor(R.color.text_black_200),
                        getResources().getColor(R.color.text_black_400)
                });

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconTintList(iconColorStates);
        bottomNavigationView.setItemTextColor(iconColorStates);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        getFragment(new DashboardFragment());
                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case R.id.search:
                        bottomNavigationView.getMenu().findItem(R.id.search).setChecked(true);
                        getFragment(new SearchFragment());
                        break;
                    case R.id.add:
                        bottomNavigationView.getMenu().findItem(R.id.add).setChecked(true);
                        getFragment(new DashboardFragment());
                        break;
                    case R.id.favorite:
                        bottomNavigationView.getMenu().findItem(R.id.favorite).setChecked(true);
                        getFragment(new RoadmapFragment());
                        break;
                    case R.id.account:
                        bottomNavigationView.getMenu().findItem(R.id.account).setChecked(true);
                        getFragment(new AccountFragment());
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                return;
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null)
        {
            Glide.with(getApplicationContext()).load(currentUser.getPhotoUrl().toString())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(accountImage);
        }
    }

    private void getFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}