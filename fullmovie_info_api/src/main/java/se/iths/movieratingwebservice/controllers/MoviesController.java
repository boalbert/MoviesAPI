package se.iths.movieratingwebservice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import se.iths.movieratingwebservice.dtos.*;
import se.iths.movieratingwebservice.service.MovieService;


@RestController
public class MoviesController {

	MovieService movieService;

	RestTemplate restTemplate;

	public MoviesController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/movies/{id}")
	public MovieWithInfoDto getMovie(@PathVariable long id) {

		// Finds the object which holds references to the other movies
		MovieDto movieDto = getMovies(id);

		// Which Ids to find in the other services
		long genreId = movieDto.getGenreId();
		long languageId = movieDto.getLanguageId();
		long directorId = movieDto.getDirectorId();

		// Search for the ids in the other APIs
		GenreDto genreDto = getGenres(genreId);
		LanguageDto languageDto = getLanguages(languageId);
		DirectorDto directorDto = getDirectorInfo(directorId);

		// Return to client
		return new MovieWithInfoDto(movieDto, directorDto, genreDto.getGenre(), languageDto.getLanguage());

	}

	public MovieDto getMovies(long id) {
		final String uri = "http://localhost:5054/movies/" + id;

		return restTemplate.getForObject(uri, MovieDto.class);

	}

	public DirectorDto getDirectorInfo(long id) {

		final String uri = "http://localhost:5050/directors/" + id;

		return restTemplate.getForObject(uri, DirectorDto.class);


	}

	public GenreDto getGenres(long id) {

		final String uri = "http://localhost:5053/genre/" + id;

		return restTemplate.getForObject(uri, GenreDto.class);

	}

	public LanguageDto getLanguages(long id) {

		final String uri = "http://localhost:5052/languages/" + id;

		return restTemplate.getForObject(uri, LanguageDto.class);

	}


}




