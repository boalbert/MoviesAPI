package se.iths.movieratingwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import se.iths.movieratingwebservice.dtos.MovieDto;

@SpringBootApplication
public class MovieratingwebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieratingwebserviceApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            MovieDto quote = restTemplate.getForObject(
                    "http://localhost:5054/movies/1", MovieDto.class);
            System.out.println(quote);

        };


    }

}


