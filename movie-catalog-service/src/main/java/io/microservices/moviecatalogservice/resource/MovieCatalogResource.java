package io.microservices.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.netflix.discovery.DiscoveryClient;

import io.microservices.moviecatalogservice.model.CatalogItem;
import io.microservices.moviecatalogservice.model.Movie;
import io.microservices.moviecatalogservice.model.Rating;
import io.microservices.moviecatalogservice.model.UserRating;
import io.microservices.moviecatalogservice.repsitory.MovieCatalogRepository;



@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private MovieCatalogRepository movieCatalogRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * @Autowired private WebClient.Builder webClientBuilder;
	 */
	/*
	 * @Autowired private DiscoveryClient discoveryClient;
	 */
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getMovieCatalog(@PathVariable("userId") String userId){
		
		//discoveryClient.getInstancesById("RATINGS-INFO-SERVICE");
		UserRating userRating = restTemplate.getForObject("http://RATINGS-INFO-SERVICE/ratingsdata/users/"+userId, UserRating.class);
		return userRating.getUserRating().stream().map(rating -> {
			//Rest Template
			//for each movie ID, call movie info service and get details
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId(), Movie.class);
			
			//Webclient Builder
			/*Movie movie = webClientBuilder.build()
				.get()
			    .uri("http://localhost:8082/movies/"+rating.getMovieId())
			    .retrieve()
			    .bodyToMono(Movie.class) //reactive programming async it waits for the response
			    .block();//blocking execution till response is returned
			    */
			
			return new CatalogItem(movie.getMovieId(), movie.getMovie_name(), movieCatalogRepository.findById(movie.getMovieId()).orElse(null).getDescription(), rating.getRating());
				
				
		}).collect(Collectors.toList());
					
		//return movieCatalogRepository.findByMovieID(userID);
				 
	}

}
