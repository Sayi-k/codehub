package com.catalog.movie.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.movie.model.MovieCatalog;
import com.catalog.movie.model.MovieCatalogResult;
import com.catalog.movie.model.response.MovieInfo;
import com.catalog.movie.model.response.MovieRating;
import com.catalog.movie.service.MovieInfoService;
import com.catalog.movie.service.RatingDataService;

@RestController
@RequestMapping("/movies")
@RefreshScope
public class MovieCatalogController {

	@Autowired
	MovieInfoService movieInfoService;
	
	@Autowired
	RatingDataService ratingDataService;
	
	@Value("${main.message}")
	String message;

	@GetMapping("/user/{userId}")
	public ResponseEntity<MovieCatalogResult> getMovieCatalog(@PathVariable("userId") String userId) {

		MovieRating movieRating = ratingDataService.getRatingDataByUserId(userId);

		List<MovieCatalog> movieCatalogList = 
		movieRating.getRatings().stream().map(rating -> {
			MovieInfo movieInfo = movieInfoService.getMovieInfoById(rating);
			return new MovieCatalog(movieInfo.getName(), movieInfo.getDesc(), rating.getRating());
		}).collect(Collectors.toList());

		MovieCatalogResult movieCatalogResult = new MovieCatalogResult();
		movieCatalogResult.addAllToMovieCatalogs(movieCatalogList);

		return ResponseEntity.ok(movieCatalogResult);
	}
	
	@GetMapping("/message")
	public ResponseEntity<String> getMessageFromConfigServer(){
		return ResponseEntity.ok(message);
	}

}
