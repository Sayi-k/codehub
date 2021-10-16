package com.info.movie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.movie.model.MovieInfo;

@RestController
@RequestMapping("/info")
public class MovieInfoController {

	@GetMapping("/details/{movieId}")
	public ResponseEntity<MovieInfo> getMovieInfo(@PathVariable("movieId") String movieId){
		MovieInfo info = new MovieInfo(111,"Rose","Romantic");
		return ResponseEntity.ok(info);
	}
}
