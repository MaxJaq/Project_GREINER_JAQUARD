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
import android.widget.EditText;

import com.esilv.project_greiner_jaquard.R;
import com.esilv.project_greiner_jaquard.adapters.YoutubeSearchItemAdapter;
import com.esilv.project_greiner_jaquard.api.YoutubeService;
import com.esilv.project_greiner_jaquard.models.YoutubeSearchItem;
import com.esilv.project_greiner_jaquard.models.YoutubeSearchResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeActivity extends AppCompatActivity {
    private static final String TAG = "YoutubeActivity";
    private static final String API_KEY = "AIzaSyCgTY6Lhj-eSgwapJfDlFQpWT5UOVt1a9I";

    private EditText editText;
    private RecyclerView recyclerView;
    private YoutubeService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);


        //Initialize and Assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.nav_home);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:

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
