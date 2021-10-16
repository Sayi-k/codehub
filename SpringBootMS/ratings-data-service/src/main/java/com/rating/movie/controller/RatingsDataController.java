package com.rating.movie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.movie.model.MovieRating;
import com.rating.movie.model.Rating;

@RestController
@RequestMapping("/rating")
public class RatingsDataController {

	@GetMapping("/user/{userId}")
	public ResponseEntity<MovieRating> getRating(@PathVariable("userId") String userId){
		MovieRating movieRating = new MovieRating();
		movieRating.addRating(new Rating(4.2, 111));
		movieRating.addRating(new Rating(4.6, 112));
		return ResponseEntity.ok(movieRating);
	}
}
