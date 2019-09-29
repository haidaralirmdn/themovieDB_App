package com.app.filmindonesia.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.filmindonesia.data.PublicRepository;
import com.app.filmindonesia.di.Injection;
import com.app.filmindonesia.ui.detail.movie.DetailViewModel;
import com.app.filmindonesia.ui.detail.tvshow.DetailShowViewModel;
import com.app.filmindonesia.ui.movie.MovieViewModel;
import com.app.filmindonesia.ui.tvshow.TvShowViewModel;


public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    private final PublicRepository publicRepository;

    public ViewModelFactory(PublicRepository publicRepository) {
        this.publicRepository = publicRepository;
    }

    public static ViewModelFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository());
                }
            }
        }
        return INSTANCE;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(publicRepository);
        } else if (modelClass.isAssignableFrom(DetailShowViewModel.class)) {
            return (T) new DetailShowViewModel(publicRepository);
        } else if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(publicRepository);
        } else if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            return (T) new TvShowViewModel(publicRepository);
        }

        throw new IllegalArgumentException("ViewModel dengan nama " + modelClass.getName() + " tidak ditemukan.");
    }


}
