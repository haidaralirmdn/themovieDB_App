package com.app.filmindonesia.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.app.filmindonesia.data.local.LocalRepository;
import com.app.filmindonesia.data.local.entity.MovieLocal;
import com.app.filmindonesia.data.local.entity.TvShowLocal;
import com.app.filmindonesia.data.remote.RemoteRepository;
import com.app.filmindonesia.data.remote.response.movie.Movie;
import com.app.filmindonesia.data.remote.response.movie.detail.ResponseDetailMovie;
import com.app.filmindonesia.data.remote.response.tvshow.TvShow;
import com.app.filmindonesia.data.remote.response.tvshow.detail.ResponseDetailTvShow;

import java.util.ArrayList;
import java.util.List;

public class PublicRepository implements PublicDataSource {

    private volatile static PublicRepository INSTANCE = null;

    private final LocalRepository localRepository;
    private final RemoteRepository remoteRepository;

    public PublicRepository(LocalRepository localRepository, RemoteRepository remoteRepository) {
        this.localRepository = localRepository;
        this.remoteRepository = remoteRepository;
    }

    public static PublicRepository getInstance(LocalRepository localRepository, RemoteRepository remoteRepository) {
        if (INSTANCE == null) {
            INSTANCE = new PublicRepository(localRepository, remoteRepository);
        }
        return INSTANCE;
    }

    @Override
    public LiveData<List<MovieLocal>> getAllMovies(String apiKey, String language, String page, String region) {
        MutableLiveData<List<MovieLocal>> movieResult = new MutableLiveData<>();

        remoteRepository.getAllMovies(apiKey, language, page, region, new RemoteRepository.LoadMoviesCallback() {
            @Override
            public void onMoviesReceived(List<Movie> movies) {
                ArrayList<MovieLocal> movieLocalArrayList = new ArrayList<>();
                for (int i = 0; i < movies.size(); i++) {
                    Movie movieRemote = movies.get(i);
                    MovieLocal movieLocal = new MovieLocal(
                            movieRemote.getId(),
                            movieRemote.getTitle(),
                            movieRemote.getOriginalTitle(),
                            movieRemote.getOriginalLanguage(),
                            movieRemote.getOverview(),
                            movieRemote.getReleaseDate(),
                            movieRemote.getPosterPath(),
                            movieRemote.getVoteAverage(),
                            false);
                    movieLocalArrayList.add(movieLocal);
                }
                movieResult.postValue(movieLocalArrayList);
            }

            @Override
            public void onMoviesFailedReceived() {

            }
        });
        return movieResult;
    }

    @Override
    public LiveData<MovieLocal> getDetailMovie(String movieId, String apiKey, String language) {
        MutableLiveData<MovieLocal> movieDetailResult = new MutableLiveData<>();

        remoteRepository.getDetailMovie(movieId, apiKey, language,  new RemoteRepository.LoadDetailMovieCallback() {
            @Override
            public void onDetailMovieReceived(ResponseDetailMovie detailMovie) {
                MovieLocal movieLocal = new MovieLocal(
                        detailMovie.getId(),
                        detailMovie.getTitle(),
                        detailMovie.getOriginalTitle(),
                        detailMovie.getOriginalLanguage(),
                        detailMovie.getOverview(),
                        detailMovie.getReleaseDate(),
                        detailMovie.getPosterPath(),
                        detailMovie.getVoteAverage(),
                        false);

                movieDetailResult.postValue(movieLocal);
            }

            @Override
            public void onDetailMovieFailedReceived() {

            }
        });

        return movieDetailResult;
    }

    @Override
    public LiveData<List<TvShowLocal>> getAllTvShows(String apiKey, String language, String page) {
        MutableLiveData<List<TvShowLocal>> tvShowResult = new MutableLiveData<>();

        remoteRepository.getAllTvShow(apiKey, language, page, new RemoteRepository.LoadTvShowsCallback() {
            @Override
            public void onTvShowsReceived(List<TvShow> tvShows) {
                ArrayList<TvShowLocal> tvShowLocalArrayList = new ArrayList<>();
                for (int i = 0; i < tvShows.size(); i++) {
                    TvShow tvShowRemote = tvShows.get(i);
                    TvShowLocal tvShowLocal = new TvShowLocal(
                        tvShowRemote.getId(),
                            tvShowRemote.getName(),
                            tvShowRemote.getOriginalName(),
                            tvShowRemote.getOriginalLanguage(),
                            tvShowRemote.getOverview(),
                            tvShowRemote.getFirstAirDate(),
                            tvShowRemote.getPosterPath(),
                            tvShowRemote.getVoteAverage(),
                            false);
                    tvShowLocalArrayList.add(tvShowLocal);
                }
                tvShowResult.postValue(tvShowLocalArrayList);
            }

            @Override
            public void onTvShowsFailedReceived() {

            }
        });
        return tvShowResult;
    }

    @Override
    public LiveData<TvShowLocal> getDetailTvShow(String tvShowId, String apiKey, String language) {
        MutableLiveData<TvShowLocal> tvShowResult = new MutableLiveData<>();

        remoteRepository.getDetailTvShow(tvShowId, apiKey, language, new RemoteRepository.LoadDetailTvShowCallback() {
            @Override
            public void onDetailTvShowReceived(ResponseDetailTvShow detailTvShow) {
                TvShowLocal tvShowLocal = new TvShowLocal(
                        detailTvShow.getId(),
                        detailTvShow.getName(),
                        detailTvShow.getOriginalName(),
                        detailTvShow.getOriginalLanguage(),
                        detailTvShow.getOverview(),
                        detailTvShow.getFirstAirDate(),
                        detailTvShow.getPosterPath(),
                        detailTvShow.getVoteAverage(),
                        false);
                tvShowResult.postValue(tvShowLocal);
            }

            @Override
            public void onDetailTvShowsFailedReceived() {

            }
        });

        return tvShowResult;
    }
}
