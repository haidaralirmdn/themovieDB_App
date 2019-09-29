package com.app.filmindonesia.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.filmindonesia.data.PublicRepository;
import com.app.filmindonesia.data.local.entity.TvShowLocal;

import java.util.List;

public class TvShowViewModel extends ViewModel {
    private PublicRepository publicRepository;

    public TvShowViewModel(PublicRepository publicRepository) {
        this.publicRepository = publicRepository;
    }

    public LiveData<List<TvShowLocal>> getTvShows(String apiKey, String language, String page) {
        return publicRepository.getAllTvShows(apiKey, language, page);
    }
}
