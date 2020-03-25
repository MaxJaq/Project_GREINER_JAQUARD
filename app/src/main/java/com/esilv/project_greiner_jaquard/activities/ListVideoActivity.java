package com.esilv.project_greiner_jaquard.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.esilv.project_greiner_jaquard.R;
import com.esilv.project_greiner_jaquard.adapters.MyChallengeAdapter;
import com.esilv.project_greiner_jaquard.models.Challenge;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListVideoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Vector<Challenge> myChallenge = new Vector<>();
    private MyChallengeAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_video);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView2);

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=-FUUibQBeL4\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=qTcFPMbsLWM\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=jVZnk22cbUg\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=e35YHFinxBM\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=JgXeIv6nNow\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=8aaXZDazPxs\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));


        myAdapter= new MyChallengeAdapter(myChallenge);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(myAdapter);



        //Initialize and Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.nav_challenges);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext()
                                , YoutubeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_challenges:

                        return true;

                    case R.id.nav_score:
                        startActivity(new Intent(getApplicationContext()
                                , Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
}
