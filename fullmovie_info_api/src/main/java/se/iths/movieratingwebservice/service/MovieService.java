package se.iths.movieratingwebservice.service;

import se.iths.movieratingwebservice.dtos.MovieWithInfoDto;

import java.util.List;

public interface MovieService {

    List<MovieWithInfoDto> getAll();
}
