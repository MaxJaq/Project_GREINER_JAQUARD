package com.esilv.project_greiner_jaquard.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.esilv.project_greiner_jaquard.R;
import com.esilv.project_greiner_jaquard.activities.DetailActivity;
import com.esilv.project_greiner_jaquard.models.Snippet;
import com.esilv.project_greiner_jaquard.models.YoutubeSearchItem;

public class SearchItemViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView description;
    private ImageView thumbnail;

    public SearchItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.title);
        this.description = itemView.findViewById(R.id.description);
        this.thumbnail = itemView.findViewById(R.id.thumbnail);
    }

    public void bind(final YoutubeSearchItem youTubeSearchItem) {
        final Snippet snippet = youTubeSearchItem.getSnippet();
        title.setText(snippet.getTitle());
        description.setText(snippet.getDescription());

        Glide.with(itemView).load(snippet.getThumbnailUrl()).into(thumbnail);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.start(v.getContext(), youTubeSearchItem.getId().getVideoId());
            }
        });
    }
}
