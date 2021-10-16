package com.catalog.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class MovieCatalog {

	private String movieName;
	private String desc;
	private double rating;
}
