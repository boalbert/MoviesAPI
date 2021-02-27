package se.mueller.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class DirectorsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectorsApiApplication.class, args);

    }

}
