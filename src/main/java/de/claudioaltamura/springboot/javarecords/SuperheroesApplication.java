package de.claudioaltamura.springboot.javarecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SuperheroesApplication {

	@Autowired
	private CityService cityService;

	@Autowired
	private SuperheroService superheroService;

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return args -> {
//				final var nyc = cityService.add(new City("New York", "NYC"));
//
//				superheroService.add(new Superhero("Spiderman", "Peter Parker", 89.0D, nyc));
//				superheroService.add(new Superhero("Hulk", "Bruce Banner", 100.0D, nyc));
//			};
//		}

}
