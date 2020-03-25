package com.esilv.project_greiner_jaquard.models;

import com.google.android.youtube.player.YouTubePlayerView;

public class Challenge {
    private String videoURL;

    public Challenge(String videoURL){
        this.videoURL = videoURL;
    }

    public String getVideoURL(){return  videoURL;}
    public void setVideoURL(){this.videoURL = videoURL;}
}
