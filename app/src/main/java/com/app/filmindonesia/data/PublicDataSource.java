package com.app.filmindonesia.data;

import androidx.lifecycle.LiveData;

import com.app.filmindonesia.data.local.entity.MovieLocal;
import com.app.filmindonesia.data.local.entity.TvShowLocal;

import java.util.List;

public interface PublicDataSource {
    LiveData<List<MovieLocal>> getAllMovies(String apiKey, String language, String page, String region);
    LiveData<MovieLocal> getDetailMovie(String movieId, String apiKey, String language);

    LiveData<List<TvShowLocal>> getAllTvShows(String apiKey, String language, String page);
    LiveData<TvShowLocal> getDetailTvShow(String tvShowId, String apiKey, String language);
}
