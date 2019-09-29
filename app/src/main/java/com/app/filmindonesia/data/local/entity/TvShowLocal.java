package com.app.filmindonesia.data.local.entity;

public class TvShowLocal {
    private int tvShowId;
    private String tvShowTitle;
    private String tvShowOriginalTitle;
    private String tvShowCountry;
    private String tvShowOverview;
    private String tvShowReleaseDate;
    private String tvShowImage;
    private double tvShowVote;
    private boolean bookmarked = false;


    public TvShowLocal(int tvShowId, String tvShowTitle, String tvShowOriginalTitle, String tvShowCountry, String tvShowOverview, String tvShowReleaseDate, String tvShowImage, double tvShowVote, Boolean bookmarked) {
        this.tvShowId = tvShowId;
        this.tvShowTitle = tvShowTitle;
        this.tvShowOriginalTitle = tvShowOriginalTitle;
        this.tvShowCountry = tvShowCountry;
        this.tvShowOverview = tvShowOverview;
        this.tvShowReleaseDate = tvShowReleaseDate;
        this.tvShowImage = tvShowImage;
        this.tvShowVote = tvShowVote;
        if (bookmarked != null) {
            this.bookmarked = bookmarked;
        }
    }

    public int getTvShowId() {
        return tvShowId;
    }

    public void setTvShowId(int tvShowId) {
        this.tvShowId = tvShowId;
    }

    public String getTvShowTitle() {
        return tvShowTitle;
    }

    public void setTvShowTitle(String tvShowTitle) {
        this.tvShowTitle = tvShowTitle;
    }

    public String getTvShowOriginalTitle() {
        return tvShowOriginalTitle;
    }

    public void setTvShowOriginalTitle(String tvShowOriginalTitle) {
        this.tvShowOriginalTitle = tvShowOriginalTitle;
    }

    public String getTvShowCountry() {
        return tvShowCountry;
    }

    public void setTvShowCountry(String tvShowCountry) {
        this.tvShowCountry = tvShowCountry;
    }

    public String getTvShowOverview() {
        return tvShowOverview;
    }

    public void setTvShowOverview(String tvShowOverview) {
        this.tvShowOverview = tvShowOverview;
    }

    public String getTvShowReleaseDate() {
        return tvShowReleaseDate;
    }

    public void setTvShowReleaseDate(String tvShowReleaseDate) {
        this.tvShowReleaseDate = tvShowReleaseDate;
    }

    public String getTvShowImage() {
        return tvShowImage;
    }

    public void setTvShowImage(String tvShowImage) {
        this.tvShowImage = tvShowImage;
    }

    public double getTvShowVote() {
        return tvShowVote;
    }

    public void setTvShowVote(double tvShowVote) {
        this.tvShowVote = tvShowVote;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
