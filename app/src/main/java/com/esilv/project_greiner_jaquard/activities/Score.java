package com.esilv.project_greiner_jaquard.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.esilv.project_greiner_jaquard.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Initialize and Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.nav_score);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext()
                                , SecondActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_challenges:
                        startActivity(new Intent(getApplicationContext()
                                , YoutubeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_score:

                        return true;
                }

                return false;
            }
        });



    }
}
