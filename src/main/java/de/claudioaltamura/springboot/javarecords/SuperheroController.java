package de.claudioaltamura.springboot.javarecords;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperheroController {

	private final SuperHeroService superHeroService;

	public SuperheroController(SuperHeroService superHeroService) {
		this.superHeroService = superHeroService;
	}

	@GetMapping("/superheroes")
	public ResponseEntity<List<Superhero>> getAll(){
		return ResponseEntity.ok(superHeroService.findAll());
	}

}