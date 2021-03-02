package se.joakimliden.springlab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.joakimliden.springlab.entities.Language;
import se.joakimliden.springlab.repositories.LanguageRepository;

@Configuration
public class LoadDatabaseLanguage {

	@Bean
	CommandLineRunner loadDatabase(LanguageRepository languageRepository) {
		return args -> {

			languageRepository.save(new Language(1, "English"));
			languageRepository.save(new Language(2, "French"));
			languageRepository.save(new Language(3, "Swedish"));
			languageRepository.save(new Language(4, "German"));
			languageRepository.save(new Language(5, "Danish"));

		};
	}
}

