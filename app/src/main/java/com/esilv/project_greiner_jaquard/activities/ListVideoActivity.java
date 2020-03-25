package com.esilv.project_greiner_jaquard.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.esilv.project_greiner_jaquard.R;
import com.esilv.project_greiner_jaquard.adapters.MyChallengeAdapter;
import com.esilv.project_greiner_jaquard.models.Challenge;

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

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eWEF1Zrmdow\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eWEF1Zrmdow\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eWEF1Zrmdow\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eWEF1Zrmdow\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eWEF1Zrmdow\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));

        myChallenge.add(new Challenge("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eWEF1Zrmdow\" frameborder=\"0\" allowfullscreen=\"allowfullscreen\"></iframe>"));


        myAdapter= new MyChallengeAdapter(myChallenge);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(myAdapter);

    }
}
