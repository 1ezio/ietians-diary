package com.iet.ietians_diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        int SPLASH_SCREEN_DURATION = 3000;
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the SignIn-Activity. */
                Intent mainIntent = new Intent(SplashScreen.this,SignIn.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();


            }
        }, SPLASH_SCREEN_DURATION);
    }


}