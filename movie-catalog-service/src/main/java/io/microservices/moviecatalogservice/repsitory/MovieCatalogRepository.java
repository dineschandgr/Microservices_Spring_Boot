package io.microservices.moviecatalogservice.repsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.microservices.moviecatalogservice.model.CatalogItem;

public interface MovieCatalogRepository extends CrudRepository<CatalogItem, String> {

	public List<CatalogItem> findByMovieId(String userId);
	
	
}
