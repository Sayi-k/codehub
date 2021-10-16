package com.catalog.movie.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.catalog.movie.model.response.MovieRating;
import com.catalog.movie.model.response.Rating;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class RatingDataService {
	
	@Autowired
	RestTemplate restTemplate;

	@CircuitBreaker(name = "catalogService", fallbackMethod = "getRatingDataByUserIdFallack")
	public MovieRating getRatingDataByUserId(String userId) {
		return restTemplate.getForObject("http://RATINGS-DATA-SERVICE/rating/user/" + userId,
				MovieRating.class);
	}
	
	public MovieRating getRatingDataByUserIdFallack(Exception ex) {
		return new MovieRating(Arrays.asList(new Rating(0.0, 000)));
	}
}
