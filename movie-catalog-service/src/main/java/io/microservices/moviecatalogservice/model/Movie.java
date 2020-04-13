package io.microservices.moviecatalogservice.model;

public class Movie {
	
	private String movieId;
	private String movie_name;
	 
    public Movie() {
    	
    }
    
	public Movie(String movieId, String movie_name) {
    	this.movieId = movieId;
    	this.movie_name = movie_name;
    }
	
	public String getMovieId() {
		return movieId;
	}
	
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
	

}
