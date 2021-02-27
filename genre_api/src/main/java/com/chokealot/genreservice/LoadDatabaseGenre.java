package com.chokealot.genreservice;

import com.chokealot.genreservice.models.Genre;
import com.chokealot.genreservice.repository.GenreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabaseGenre {

	@Bean
	CommandLineRunner loadDatabase(GenreRepository genreRepository) {
		return args -> {

			genreRepository.save(new Genre(1, "Sci-Fi"));
			genreRepository.save(new Genre(2, "Drama"));
			genreRepository.save(new Genre(3, "Romance"));
			genreRepository.save(new Genre(4, "Horror"));

		};
	}
}
