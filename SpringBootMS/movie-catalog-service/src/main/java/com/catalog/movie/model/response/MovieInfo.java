package com.catalog.movie.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieInfo {
	
	private int movieId;
	private String name;
	private String desc;
}
