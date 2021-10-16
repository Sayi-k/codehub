package com.catalog.movie.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class MovieCatalogResult {

	private List<MovieCatalog> movieCatalogs;
	
	public MovieCatalogResult() {
		movieCatalogs = new ArrayList<>();
	}
	
	public void addToMovieCatalogs(MovieCatalog movieCatalog) {
		this.movieCatalogs.add(movieCatalog);
	}
	
	public void addAllToMovieCatalogs(List<MovieCatalog> movieCatalogs) {
		this.movieCatalogs.addAll(movieCatalogs);
	}
}
