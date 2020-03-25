package com.esilv.project_greiner_jaquard.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.esilv.project_greiner_jaquard.R;
import com.esilv.project_greiner_jaquard.activities.Score;
import com.esilv.project_greiner_jaquard.activities.SecondActivity;
import com.esilv.project_greiner_jaquard.adapters.YoutubeSearchItemAdapter;
import com.esilv.project_greiner_jaquard.api.YoutubeService;
import com.esilv.project_greiner_jaquard.models.YoutubeSearchItem;
import com.esilv.project_greiner_jaquard.models.YoutubeSearchResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeActivity extends AppCompatActivity {
    private static final String TAG = "YoutubeActivity";
    private static final String API_KEY = "AIzaSyDs48Tpp5DJtsvoR1zNobmJYhfHGrTPzsY";

    private EditText editText;
    private RecyclerView recyclerView;
    private YoutubeService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        editText = findViewById(R.id.editText);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(YoutubeActivity.this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(YoutubeService.class);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() >= 0) {
                    launchSearch(s.toString());
                } else {
                    launchSearch("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }

    private void launchSearch(String query) {
        service.search(query, API_KEY).enqueue(new Callback<YoutubeSearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<YoutubeSearchResponse> call, @NonNull Response<YoutubeSearchResponse> response) {
                Log.d(TAG, "onResponse");
                if (response.isSuccessful()) {
                    YoutubeSearchResponse youTubeSearchResponse = response.body();
                    List<YoutubeSearchItem> itemList = youTubeSearchResponse.getItems();
                    recyclerView.setAdapter(new YoutubeSearchItemAdapter(itemList));
                }
            }

            @Override
            public void onFailure(Call<YoutubeSearchResponse> call, Throwable t) {
                Log.e(TAG, "onFailure", t);
            }
        });
    }




}
