package com.app.filmindonesia.data.local.entity;

public class MovieLocal {
    private int movieId;
    private String movieTitle;
    private String movieOriginalTitle;
    private String movieCountry;
    private String movieOverview;
    private String movieReleaseDate;
    private String movieImage;
    private double movieVote;
    private boolean bookmarked = false;


    public MovieLocal(int movieId, String movieTitle, String movieOriginalTitle, String movieCountry, String movieOverview, String movieReleaseDate, String movieImage, double movieVote, Boolean bookmarked) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieOriginalTitle = movieOriginalTitle;
        this.movieCountry = movieCountry;
        this.movieOverview = movieOverview;
        this.movieReleaseDate = movieReleaseDate;
        this.movieImage = movieImage;
        this.movieVote = movieVote;
        if (bookmarked != null) {
            this.bookmarked = bookmarked;
        }
    }


    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieOriginalTitle() {
        return movieOriginalTitle;
    }

    public void setMovieOriginalTitle(String movieOriginalTitle) {
        this.movieOriginalTitle = movieOriginalTitle;
    }

    public String getMovieCountry() {
        return movieCountry;
    }

    public void setMovieCountry(String movieCountry) {
        this.movieCountry = movieCountry;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public double getMovieVote() {
        return movieVote;
    }

    public void setMovieVote(double movieVote) {
        this.movieVote = movieVote;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
