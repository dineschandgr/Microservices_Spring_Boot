package io.microservices.movieinfoservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.microservices.movieinfoservice.model.Movie;
import io.microservices.movieinfoservice.repsitory.MovieInfoRepository;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	
	@Autowired
	private MovieInfoRepository movieInfoRepository;
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId){
		return movieInfoRepository.findById(movieId).orElse(null);
	}

}
