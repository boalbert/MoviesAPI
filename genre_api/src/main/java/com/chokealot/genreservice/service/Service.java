package com.chokealot.genreservice.service;

import com.chokealot.genreservice.dto.GenreDto;
import com.chokealot.genreservice.models.Genre;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface Service {

    List<GenreDto> getAllGenres();

    Optional<GenreDto> getOne(int id);

    GenreDto createGenre(GenreDto genreDto);

    void delete(@PathVariable int id);

    GenreDto replace(int id, GenreDto genreDto);

    GenreDto update(int id, GenreDto genreDto);

    Optional<GenreDto> findGenreByGenre(String searchTerm);
}
