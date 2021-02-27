package com.chokealot.genreservice.mappers;

import com.chokealot.genreservice.dto.GenreDto;
import com.chokealot.genreservice.models.Genre;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Mapper {

    public Mapper() {

    }

    public GenreDto mapp(Genre genre)  {
        return new GenreDto(genre.getId(), genre.getGenre());
    }

    public Genre mapp(GenreDto genreDto)    {
        return new Genre(genreDto.getId(), genreDto.getGenre());
    }

    public Optional<GenreDto> mapp(Optional<Genre> optionalGenre){
        if (optionalGenre.isEmpty())
            return Optional.empty();
        return Optional.of(mapp(optionalGenre.get()));
    }

    public List<GenreDto> mapp(List<Genre> all) {
        return all
                .stream()
                .map(this::mapp)
                .collect(Collectors.toList());
    }
}
