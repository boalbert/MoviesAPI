package se.iths.movieratingwebservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import se.iths.movieratingwebservice.dtos.MovieDto;

@SpringBootApplication
@Configuration
public class MovieratingwebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieratingwebserviceApplication.class, args);
    }
}


