package com.app.filmindonesia.ui.detail.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.filmindonesia.data.PublicRepository;
import com.app.filmindonesia.data.local.entity.TvShowLocal;
import com.dzakdzaks.movieLocals.BuildConfig;


public class DetailShowViewModel extends ViewModel {
    private TvShowLocal mTvShowLocal;
    private String tvShowId;

    private PublicRepository publicRepository;

    public DetailShowViewModel(PublicRepository publicRepository) {
        this.publicRepository = publicRepository;
    }


    public void setTvShowId(String tvShowId) {
        this.tvShowId = tvShowId;
    }

    public LiveData<TvShowLocal> getTvShow() {
        return publicRepository.getDetailTvShow(tvShowId, BuildConfig.API_KEY, BuildConfig.LANGUAGE);
    }
}
