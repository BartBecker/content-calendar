package dev.bart.contentcalendar;

import dev.bart.contentcalendar.model.Content;
import dev.bart.contentcalendar.model.Status;
import dev.bart.contentcalendar.model.Type;
import dev.bart.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// Print out beans in terminal
		//		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

	// Bootstrapping Inserting stuff after init
	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {
			System.out.println("Hello Bart");
			Content c = new Content(null,
					"My video idea",
					"My video idea about stuff",
					Status.IDEA,
					Type.VIDEO,
					LocalDateTime.now(),
					null,
					""
			);

			repository.save(c);
		};
	}

}
