package com.app.filmindonesia.ui.movie;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.app.filmindonesia.data.local.entity.MovieLocal;
import com.app.filmindonesia.viewmodel.ViewModelFactory;
import com.dzakdzaks.movieLocals.BuildConfig;
import com.dzakdzaks.movieLocals.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MovieAdapter adapter;
    private MovieViewModel viewModel;
    private List<MovieLocal> movieLocals;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvMovie);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            viewModel = obtainViewModel(getActivity());
            progressBar.setVisibility(View.VISIBLE);

            viewModel.getMovies(BuildConfig.API_KEY, BuildConfig.LANGUAGE, BuildConfig.PAGE, BuildConfig.REGION)
                    .observe(this, movies -> {
                        progressBar.setVisibility(View.GONE);
                        adapter.setMovieLocals(movies);
                        adapter.notifyDataSetChanged();
                    });

            adapter = new MovieAdapter(getActivity());
            adapter.setMovieLocals(movieLocals);


        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @NonNull
    private static MovieViewModel obtainViewModel(FragmentActivity activity) {

        ViewModelFactory factory = ViewModelFactory.getInstance();
        return ViewModelProviders.of(activity, factory).get(MovieViewModel.class);
    }
}
