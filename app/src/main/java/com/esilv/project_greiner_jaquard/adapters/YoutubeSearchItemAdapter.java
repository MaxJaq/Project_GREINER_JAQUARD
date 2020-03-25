package com.esilv.project_greiner_jaquard.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esilv.project_greiner_jaquard.R;
import com.esilv.project_greiner_jaquard.viewholders.SearchItemViewHolder;
import com.esilv.project_greiner_jaquard.models.YoutubeSearchItem;

import java.util.ArrayList;
import java.util.List;

public class YoutubeSearchItemAdapter extends RecyclerView.Adapter<SearchItemViewHolder> {

    private final List<YoutubeSearchItem> items;

    public YoutubeSearchItemAdapter(List<YoutubeSearchItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public SearchItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_search_item, viewGroup, false);
        return new SearchItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchItemViewHolder searchItemViewHolder, int position) {
        searchItemViewHolder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}
