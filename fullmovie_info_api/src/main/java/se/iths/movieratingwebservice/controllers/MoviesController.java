package se.iths.movieratingwebservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import se.iths.movieratingwebservice.dtos.*;
import se.iths.movieratingwebservice.service.MovieService;

import java.util.List;


@RestController
public class MoviesController {

	MovieService movieService;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/movies/{id}")
	public MovieWithInfoDto getMovie(@PathVariable long id) {

		// Finds the object which holds references to the other movies
		MovieDto movieDto = getOneMovie(id);

		// Which Ids to find in the other services
		long genreId = movieDto.getGenreId();
		long languageId = movieDto.getLanguageId();
		long directorId = movieDto.getDirectorId();

		// Search for the ids in the other APIs
		GenreDto genreDto = getOneGenre(genreId);
		LanguageDto languageDto = getOneLanguage(languageId);
		DirectorDto directorDto = getOneDirector(directorId);

		// Return to client
		return new MovieWithInfoDto(movieDto, directorDto, genreDto.getGenre(), languageDto.getLanguage());
	}
	
	public MovieDto getOneMovie(long id) {
		final String uri = "http://localhost:5054/movies/" + id;

		return restTemplate.getForObject(uri, MovieDto.class);

	}

	public DirectorDto getOneDirector(long id) {

		final String uri = "http://localhost:5050/directors/" + id;

		return restTemplate.getForObject(uri, DirectorDto.class);


	}

	public GenreDto getOneGenre(long id) {

		final String uri = "http://localhost:5053/genre/" + id;

		return restTemplate.getForObject(uri, GenreDto.class);

	}

	public LanguageDto getOneLanguage(long id) {

		final String uri = "http://localhost:5052/languages/" + id;

		return restTemplate.getForObject(uri, LanguageDto.class);

	}


}




