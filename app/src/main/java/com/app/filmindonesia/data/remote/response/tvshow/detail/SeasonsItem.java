package com.app.filmindonesia.data.remote.response.tvshow.detail;

import com.google.gson.annotations.SerializedName;

public class SeasonsItem{

	@SerializedName("air_date")
	private String airDate;

	@SerializedName("overview")
	private String overview;

	@SerializedName("episode_count")
	private int episodeCount;

	@SerializedName("name")
	private String name;

	@SerializedName("season_number")
	private int seasonNumber;

	@SerializedName("id")
	private int id;

	@SerializedName("poster_path")
	private String posterPath;

	public void setAirDate(String airDate){
		this.airDate = airDate;
	}

	public String getAirDate(){
		return airDate;
	}

	public void setOverview(String overview){
		this.overview = overview;
	}

	public String getOverview(){
		return overview;
	}

	public void setEpisodeCount(int episodeCount){
		this.episodeCount = episodeCount;
	}

	public int getEpisodeCount(){
		return episodeCount;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSeasonNumber(int seasonNumber){
		this.seasonNumber = seasonNumber;
	}

	public int getSeasonNumber(){
		return seasonNumber;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setPosterPath(String posterPath){
		this.posterPath = posterPath;
	}

	public String getPosterPath(){
		return posterPath;
	}
}