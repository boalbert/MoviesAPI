package com.chokealot.genreservice;

import com.chokealot.genreservice.dto.GenreDto;
import com.chokealot.genreservice.models.Genre;
import com.chokealot.genreservice.service.Service;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@WebMvcTest(Genre.class)
public class MvcTest {

    @MockBean
    Service service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllGenresWithUrlAsJson() throws Exception   {
        Mockito.when(service.getAllGenres())
                .thenReturn(List.of(new GenreDto(2,"TestGenre")));

        var testResult = mockMvc.perform(MockMvcRequestBuilders.get("/genre")
            .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(testResult.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    void getOneGenreWithUrlAsJson() throws Exception    {
        Mockito.when(service.getOne(1)).thenReturn((Optional<GenreDto>) service.getOne(1));

        var testResult = mockMvc.perform(MockMvcRequestBuilders.get("/genre/1")
            .accept(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(testResult.getResponse().getStatus()).isEqualTo(200);
    }
}
