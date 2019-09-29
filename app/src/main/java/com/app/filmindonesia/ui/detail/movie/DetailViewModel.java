package com.app.filmindonesia.ui.detail.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.filmindonesia.data.PublicRepository;
import com.app.filmindonesia.data.local.entity.MovieLocal;
import com.dzakdzaks.movieLocals.BuildConfig;


public class DetailViewModel extends ViewModel {
    private MovieLocal mMovieLocal;
    private String movieId;
    private PublicRepository publicRepository;

    public DetailViewModel(PublicRepository publicRepository) {
        this.publicRepository = publicRepository;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public LiveData<MovieLocal> getDetailMovie() {
        return publicRepository.getDetailMovie(movieId, BuildConfig.API_KEY, BuildConfig.LANGUAGE);
    }
}
