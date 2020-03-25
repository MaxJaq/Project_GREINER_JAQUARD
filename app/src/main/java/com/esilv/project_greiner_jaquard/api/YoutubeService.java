package com.esilv.project_greiner_jaquard.api;

import com.esilv.project_greiner_jaquard.models.YoutubeSearchResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.Call;

public interface YoutubeService {
    @GET("search?part=snippet&type=video&maxResults=50")
    Call<YoutubeSearchResponse> search(@Query("q") String query, @Query("key") String apiKey);
}
