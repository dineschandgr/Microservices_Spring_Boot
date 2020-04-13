package io.microservices.movieinfoservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie_info")
public class Movie {
	
	@Id
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
