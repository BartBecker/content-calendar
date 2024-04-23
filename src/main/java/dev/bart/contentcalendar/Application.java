package dev.bart.contentcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		// Print out beans in terminal
		//		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

}
