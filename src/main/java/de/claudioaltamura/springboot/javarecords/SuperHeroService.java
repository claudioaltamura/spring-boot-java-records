package de.claudioaltamura.springboot.javarecords;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SuperHeroService {

	public List<Superhero> findAll() {
		final var city = new City(1L, "New York", "NYC");
		return List.of(
				new Superhero(1L, "Spiderman", "Peter Parker", 89.0D, city),
				new Superhero(2L, "Hulk", "Bruce Banner", 100.0D, city));
	}
}
