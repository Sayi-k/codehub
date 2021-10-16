package com.catalog.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.catalog.movie.model.response.MovieInfo;
import com.catalog.movie.model.response.Rating;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MovieInfoService {
	
	@Autowired
	RestTemplate restTemplate;

	@CircuitBreaker(name = "catalogService", fallbackMethod = "getMovieInfoByIdFallack")
	public MovieInfo getMovieInfoById(Rating rating) {
		return restTemplate
				.getForObject("http://MOVIE-INFO-SERVICE/info/details/" + rating.getMovieId(), MovieInfo.class);
	}
	
	public MovieInfo getMovieInfoByIdFallack(Exception ex) {
		return new MovieInfo(000, "Dummy", "Coming from Circuit breaker");
	}
}
