package com.esilv.project_greiner_jaquard.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.esilv.project_greiner_jaquard.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetailActivity  extends YouTubeBaseActivity {
    Button b;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    private static final String VIDEO_ID = "VIDEO_ID";
    private String videoId;

    public static void start(Context context, String videoId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(VIDEO_ID, videoId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);




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
                        startActivity(new Intent(getApplicationContext()
                                , ListVideoActivity.class));
                        overridePendingTransition(0,0);
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



        Intent intent = getIntent();
        if (intent != null) {
            videoId = intent.getStringExtra(VIDEO_ID);
        }


        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videoId);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize("AIzaSyD14Ma75bqoUMrcPE-P4mqCo_L8w5faa1s",onInitializedListener);
            }
        });

    }
}
