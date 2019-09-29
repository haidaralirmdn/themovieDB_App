package com.app.filmindonesia.ui.movie;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.filmindonesia.data.local.entity.MovieLocal;
import com.app.filmindonesia.ui.detail.movie.DetailActivity;
import com.app.filmindonesia.utils.GlideApp;
import com.app.filmindonesia.utils.GlobalFunction;
import com.bumptech.glide.request.RequestOptions;
import com.dzakdzaks.movieLocals.BuildConfig;
import com.dzakdzaks.movieLocals.R;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final Activity activity;
    private List<MovieLocal> movieLocals = new ArrayList<>();

    public MovieAdapter(Activity activity) {
        this.activity = activity;
    }

    private List<MovieLocal> getMovieLocals() {
        return movieLocals;
    }

    void setMovieLocals(List<MovieLocal> movieLocalList) {
        if (movieLocalList == null) return;
        this.movieLocals.clear();
        this.movieLocals.addAll(movieLocalList);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.tvTitle.setText(getMovieLocals().get(position).getMovieTitle());
        holder.tvDate.setText(GlobalFunction.dateFormater(getMovieLocals().get(position).getMovieReleaseDate()));
        holder.tvOverview.setText(getMovieLocals().get(position).getMovieOverview());
        holder.tvVote.setText(getMovieLocals().get(position).getMovieVote() + " " + activity.getResources().getString(R.string.voteFull));

        GlideApp.with(holder.itemView.getContext())
                .load(BuildConfig.BASE_URL_IMG + getMovieLocals().get(position).getMovieImage())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_circle).error(R.drawable.ic_broken_image_black))
                .into(holder.imgPoster);
        GlideApp.with(holder.itemView.getContext())
                .load(BuildConfig.BASE_URL_IMG_LANDSCAPE + getMovieLocals().get(position).getMovieImage())
                .apply(RequestOptions.placeholderOf(R.drawable.ic_circle).error(R.drawable.ic_broken_image_black))
                .into(holder.imgBg);


        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(activity, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_MOVIE, String.valueOf(getMovieLocals().get(position).getMovieId()));
            activity.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return getMovieLocals().size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvOverview;
        final TextView tvDate;
        final TextView tvVote;
        final ImageView imgPoster;
        final ImageView imgBg;

        MovieViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textMovieTitle);
            imgPoster = itemView.findViewById(R.id.imageMovie);
            imgBg = itemView.findViewById(R.id.imageMovieBg);
            tvOverview = itemView.findViewById(R.id.textMovieOverview);
            tvDate = itemView.findViewById(R.id.textMovieReleaseDate);
            tvVote = itemView.findViewById(R.id.textMovieVoteAverage);

        }
    }
}
