package com.catalog.movie.model.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieRating {

	List<Rating> ratings;

	public MovieRating() {
		ratings = new ArrayList<>();
	}

	public void addRating(Rating rating) {
		ratings.add(rating);
	}
}
