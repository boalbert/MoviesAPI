package com.chokealot.genreservice.service;

import com.chokealot.genreservice.dto.GenreDto;
import com.chokealot.genreservice.mappers.Mapper;
import com.chokealot.genreservice.models.Genre;
import com.chokealot.genreservice.repository.GenreRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements com.chokealot.genreservice.service.Service {

    private static final Mapper mapper = new Mapper();
    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) { this.genreRepository = genreRepository; }


    @Override
    public List<GenreDto> getAllGenres() {
        return mapper.mapp(genreRepository.findAll());
    }

    @Override
    public Optional<GenreDto> getOne(int id) {
        return mapper.mapp(genreRepository.findById(id));
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        if (genreDto.getGenre().isEmpty()) {
            throw new RuntimeException();
        }
            return mapper.mapp(genreRepository.save(mapper.mapp(genreDto)));
    }

    @Override
    public void delete(int id) {
        genreRepository.deleteById(id);
    }

    @Override
    public GenreDto replace(int id, GenreDto genreDto) {
        Optional<Genre> genre = genreRepository.findById(id);
        if (genre.isPresent())  {
            Genre updatedGenre = genre.get();
            updatedGenre.setGenre(genreDto.getGenre());
            return mapper.mapp(genreRepository.save(updatedGenre));
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id "+id+" not found");
    }

    @Override
    public GenreDto update(int id, GenreDto genreDto) {
        Optional<Genre> genre = genreRepository.findById(id);
        if (genre.isPresent()) {
            Genre updatedGenre = genre.get();
            if (updatedGenre != null)
                updatedGenre.setGenre(genreDto.getGenre());
                return mapper.mapp(genreRepository.save(updatedGenre));
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Update failed");
    }

    @Override
    public Optional<GenreDto> findGenreByGenre(String searchTerm) {
        Optional<Genre> genreDtoOptional = genreRepository.findGenreByGenre(searchTerm);
        if(genreDtoOptional.isPresent())
            return mapper.mapp(genreRepository.findGenreByGenre(searchTerm));
        else {
            throw new
                    ResponseStatusException(HttpStatus.NOT_FOUND, "Search result: " + searchTerm + " not found.");
        }
    }

}
