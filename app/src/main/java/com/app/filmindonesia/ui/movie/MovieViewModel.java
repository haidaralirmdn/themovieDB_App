package com.app.filmindonesia.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.filmindonesia.data.PublicRepository;
import com.app.filmindonesia.data.local.entity.MovieLocal;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private PublicRepository publicRepository;

    public MovieViewModel(PublicRepository publicRepository) {
        this.publicRepository = publicRepository;
    }

    public LiveData<List<MovieLocal>> getMovies(String apiKey, String language, String page, String region) {
        return publicRepository.getAllMovies(apiKey, language, page, region);
    }
}
