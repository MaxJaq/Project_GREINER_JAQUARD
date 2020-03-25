package com.esilv.project_greiner_jaquard.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esilv.project_greiner_jaquard.R;
import com.esilv.project_greiner_jaquard.models.Challenge;

import java.util.List;

public class MyChallengeAdapter extends RecyclerView.Adapter<MyChallengeAdapter.MyChallengeViewHolder> {

    List<Challenge> myChallenge;
    public MyChallengeAdapter(List<Challenge> myChallenge){
        this.myChallenge = myChallenge;
    }

    @Override
    public MyChallengeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.video_challenge_item,parent,false);
        return new MyChallengeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyChallengeViewHolder holder,int position){
        holder.videoWeb.loadData(myChallenge.get(position).getVideoURL(),"text/html","utf-8");
    }

    @Override
    public int getItemCount(){
        return myChallenge.size();
    }
    public class MyChallengeViewHolder extends RecyclerView.ViewHolder {

        WebView videoWeb;

        public MyChallengeViewHolder(@NonNull View itemView) {
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.videoWebView);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient(){});
        }

    }


}
